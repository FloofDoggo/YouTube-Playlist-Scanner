package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class Playlist {

    private String publishedAt;
    private String title;

    public Playlist(String publishedAt, String title) {
        this.publishedAt = publishedAt;
        this.title = title;
    }

    public Playlist() {
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
