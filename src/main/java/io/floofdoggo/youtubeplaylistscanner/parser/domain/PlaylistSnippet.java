package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class PlaylistSnippet {

    private String id;
    private Playlist snippet;

    public PlaylistSnippet(String id, Playlist snippet) {
        this.id = id;
        this.snippet = snippet;
    }

    public PlaylistSnippet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Playlist getSnippet() {
        return snippet;
    }

    public void setSnippet(Playlist snippet) {
        this.snippet = snippet;
    }
}
