package io.floofdoggo.youtubeplaylistscanner.sevice;

import io.floofdoggo.youtubeplaylistscanner.DAO.PlaylistRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.VideoRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.PlaylistEntity;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.VideoEntity;
import io.floofdoggo.youtubeplaylistscanner.parser.YoutubeParser;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.PlaylistInfo;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ParserService {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VideoRepository videoRepository;

    public void saveAll(String channelId){
        YoutubeParser youtubeParser = new YoutubeParser();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());

        for(PlaylistInfo playlistInfo: youtubeParser.getPlaylists(channelId)){
            PlaylistEntity playlistEntity = new PlaylistEntity(userEntity, playlistInfo.getTitle(), playlistInfo.getPlaylistId(), playlistInfo.getThumbnailUrl());
            playlistRepository.save(playlistEntity);
            Thread thread = new Thread(() -> {
                for(Video video: youtubeParser.getPlaylistVideos(playlistInfo.getPlaylistId())){
                    VideoEntity videoEntity = new VideoEntity(video.getTitle(), video.getPublishedAt());
                    videoEntity.setPlaylistEntity(playlistEntity);
                    videoRepository.save(videoEntity);
                }
            });
            thread.start();
        }
    }

    public Set<PlaylistEntity> getCurrentUserPlaylists(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());

        return userEntity.getPlaylistEntities();
    }
}
