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
import org.springframework.stereotype.Service;

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
        UserEntity userEntity = new UserEntity("Grzegorz", "123123", "gmail@gmail.com", 1);
        userRepository.save(userEntity);

        for(PlaylistInfo playlistInfo: youtubeParser.getPlaylists(channelId)){
            PlaylistEntity playlistEntity = new PlaylistEntity(userEntity, playlistInfo.getTitle(), playlistInfo.getPlaylistId());
            playlistRepository.save(playlistEntity);
            for(Video video: youtubeParser.getPlaylistVideos(playlistInfo.getPlaylistId())){
                VideoEntity videoEntity = new VideoEntity(video.getTitle(), video.getPublishedAt());
                videoEntity.setPlaylistEntity(playlistEntity);
                videoRepository.save(videoEntity);
            }
        }
    }
}
