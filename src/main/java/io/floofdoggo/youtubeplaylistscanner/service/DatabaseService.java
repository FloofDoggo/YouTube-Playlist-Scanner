package io.floofdoggo.youtubeplaylistscanner.service;

import io.floofdoggo.youtubeplaylistscanner.DAO.PlaylistRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.VideoRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.PlaylistEntity;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.VideoEntity;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.Playlist;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DatabaseService {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;

    public Set<PlaylistEntity> getCurrentUserPlaylists(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());

        return userEntity.getPlaylists();
    }

    public void saveAllPlaylistContent(String channelId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());
        YoutubeService youtubeParser = new YoutubeService();

        for (Playlist playlist : youtubeParser.getPlaylists(channelId)) {

            PlaylistEntity playlistEntity = new PlaylistEntity(playlist.getId(), playlist.getTitle(),
                    playlist.getThumbnailUrl());
            playlistEntity.setUsers(userEntity);
            playlistRepository.save(playlistEntity);

            for (Video video : youtubeParser.getPlaylistVideos(playlist.getId())) {
                VideoEntity videoEntity = new VideoEntity(video.getVideoId(), video.getTitle());
                if(!video.getTitle().equals("Private video") && !video.getTitle().equals("Deleted video")){
                    videoEntity.setPlaylists(playlistEntity);
                    videoRepository.save(videoEntity);
                }else{
                    System.out.println("Pominiety!");
                }
            }
        }
    }

    public void saveOnePlaylistContent(String playlistId){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername());

        YoutubeService youtubeParser = new YoutubeService();
        Playlist playlist = youtubeParser.getPlaylistInfo(playlistId);

        if(playlist != null) {
            PlaylistEntity playlistEntity = new PlaylistEntity(playlist.getId(), playlist.getTitle(),
                    playlist.getThumbnailUrl());
            playlistEntity.setUsers(userEntity);
            playlistRepository.save(playlistEntity);

            for (Video video : youtubeParser.getPlaylistVideos(playlist.getId())) {
                VideoEntity videoEntity = new VideoEntity(video.getVideoId(), video.getTitle());
                if (!video.getTitle().equals("Private video") && !video.getTitle().equals("Deleted video")) {
                    videoEntity.setPlaylists(playlistEntity);
                    videoRepository.save(videoEntity);
                } else {
                    System.out.println("Pominiety!");
                }
            }
        }
    }
}
