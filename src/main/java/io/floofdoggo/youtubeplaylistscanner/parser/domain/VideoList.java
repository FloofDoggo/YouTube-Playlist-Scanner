package io.floofdoggo.youtubeplaylistscanner.parser.domain;

import java.util.ArrayList;
import java.util.List;

public class VideoList {

    private String nextPageToken;
    private List<VideoSnippet> items;

    public VideoList(String nextPageToken, List<VideoSnippet> items) {
        this.nextPageToken = nextPageToken;
        this.items = new ArrayList<>();
    }

    public VideoList() {
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<VideoSnippet> getItems() {
        return items;
    }

    public void setItems(List<VideoSnippet> items) {
        this.items = items;
    }
}
