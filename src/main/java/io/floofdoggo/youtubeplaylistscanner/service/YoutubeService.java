package io.floofdoggo.youtubeplaylistscanner.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.*;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    private final String API_KEY = "[YOUR_API_KEY]";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Video> getPlaylistVideos(String playlistId){

        String nextPageToken = "";
        List<Video> videos = new ArrayList<>();

        while (nextPageToken != null){
            try{
                JsonParser jsonParser = objectMapper.createParser(
                        new URL("https://www.googleapis.com/youtube/v3/playlistItems?" +
                                "playlistId="+ playlistId +
                                "&pageToken=" + nextPageToken +
                                "&key=" + API_KEY +
                                "&fields=items(snippet/title,snippet/resourceId/videoId),nextPageToken" +
                                "&part=snippet" +
                                "&maxResults=50"));

                VideoJSON requestItems = objectMapper.readValue(jsonParser, VideoJSON.class);
                nextPageToken = requestItems.getNextPageToken();

                for(VideoJSON.Videos item: requestItems.getItems()){
                    videos.add(new Video(item.getSnippet().getTitle(),
                            item.getSnippet().getResourceId().getVideoId()));
                }
            }catch (Exception ex){
                ex.printStackTrace();
                break;
            }
        }
        return videos;
    }

    public List<Playlist> getPlaylists(String channelId){

        String nextPageToken = "";
        List<Playlist> playlists = new ArrayList<>();

        while (nextPageToken != null){
            try{
                JsonParser jsonParser = objectMapper.createParser(
                        new URL("https://www.googleapis.com/youtube/v3/playlists?" +
                                "channelId="+ channelId +
                                "&pageToken=" + nextPageToken +
                                "&key=" + API_KEY +
                                "&fields=items(snippet/title,snippet/thumbnails/medium/url,id),nextPageToken" +
                                "&part=snippet" +
                                "&maxResults=50"));

                PlaylistJSON requestItems = objectMapper.readValue(jsonParser, PlaylistJSON.class);
                nextPageToken = requestItems.getNextPageToken();

                for(PlaylistJSON.Playlists item : requestItems.getItems()){
                    playlists.add(new Playlist(item.getId(),
                            item.getSnippet().getTitle().getTitle(),
                            item.getSnippet().getThumbnails().getMedium().getUrl()));
                }
            }catch (Exception ex){
                ex.printStackTrace();
                break;
            }
        }
        return playlists;
    }

    public Playlist getPlaylistInfo(String playlistId) {
        try {
            JsonParser jsonParser = objectMapper.createParser(
                    new URL("https://www.googleapis.com/youtube/v3/playlists?" +
                            "&key=" + API_KEY +
                            "&id=" + playlistId +
                            "&fields=items(snippet/thumbnails/medium/url,snippet/title)" +
                            "&part=snippet"));

            PlaylistJSON requestItems = objectMapper.readValue(jsonParser, PlaylistJSON.class);
            PlaylistJSON.Playlists playlist = requestItems.getItems().get(0);
            return new Playlist(playlistId, playlist.getSnippet().getTitle().getTitle(),
                    playlist.getSnippet().getThumbnails().getMedium().getUrl());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
