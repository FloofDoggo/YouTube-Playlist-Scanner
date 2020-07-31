package io.floofdoggo.youtubeplaylistscanner.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.floofdoggo.youtubeplaylistscanner.parser.domain.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class YoutubeParser {

    private final String API_KEY = "[API_KEY]";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Video> getPlaylistVideos(String playlistId){

        String nextPageToken = "";
        List<Video> playlistItemList = new ArrayList<>();

        while (nextPageToken != null){
            try{
                JsonParser jsonParser = objectMapper.createParser(
                        new URL("https://www.googleapis.com/youtube/v3/playlistItems?" +
                                "playlistId="+ playlistId +
                                "&pageToken=" + nextPageToken +
                                "&key=" + API_KEY +
                                "&fields=items(snippet/publishedAt,snippet/title),nextPageToken" +
                                "&part=snippet" +
                                "&maxResults=50"));

                VideoList videoList = objectMapper.readValue(jsonParser, VideoList.class);
                nextPageToken = videoList.getNextPageToken();
                videoList.getItems()
                        .stream()
                        .map(x -> x.getSnippet())
                        .forEach(x -> playlistItemList.add(x));

            }catch (Exception ex){
                ex.printStackTrace();
                break;
            }
        }
        return playlistItemList;
    }

    public List<PlaylistInfo> getPlaylists(String channelId){

        String nextPageToken = "";
        List<PlaylistInfo> playlistsList = new ArrayList<>();

        while (nextPageToken != null){
            try{
                JsonParser jsonParser = objectMapper.createParser(
                        new URL("https://www.googleapis.com/youtube/v3/playlists?" +
                                "channelId="+ channelId +
                                "&pageToken=" + nextPageToken +
                                "&key=" + API_KEY +
                                "&fields=items(snippet/title,snippet/publishedAt,id),nextPageToken" +
                                "&part=snippet" +
                                "&maxResults=50"));

                PlaylistList playlistList = objectMapper.readValue(jsonParser, PlaylistList.class);

                nextPageToken = playlistList.getNextPageToken();

                playlistList.getItems()
                        .stream()
                        .forEach(x -> {
                            PlaylistInfo playlistInfo = new PlaylistInfo();
                            playlistInfo.setPlaylistId(x.getId());
                            playlistInfo.setPublishedAt(x.getSnippet().getPublishedAt());
                            playlistInfo.setTitle(x.getSnippet().getTitle());
                            playlistsList.add(playlistInfo);
                        });

            }catch (Exception ex){
                ex.printStackTrace();
                break;
            }
        }
        return playlistsList;
    }
}
