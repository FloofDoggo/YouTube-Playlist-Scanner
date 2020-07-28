package io.floofdoggo.youtubeplaylistscanner.parser.domain;

import java.util.List;

public class PlaylistList {

    private String nextPageToken;
    private List<PlaylistSnippet> items;

    public PlaylistList(List<PlaylistSnippet> playlistsItems) {
        this.items = playlistsItems;
    }

    public PlaylistList() {
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<PlaylistSnippet> getItems() {
        return items;
    }

    public void setItems(List<PlaylistSnippet> items) {
        this.items = items;
    }
}
