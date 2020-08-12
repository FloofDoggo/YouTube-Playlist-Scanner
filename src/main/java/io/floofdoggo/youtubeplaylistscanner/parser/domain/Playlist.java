package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class Playlist {

    private String publishedAt;
    private String title;
    private PlaylistThumbnail thumbnails;

    public Playlist(String publishedAt, String title, PlaylistThumbnail thumbnails) {
        this.publishedAt = publishedAt;
        this.title = title;
        this.thumbnails = thumbnails;
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

    public PlaylistThumbnail getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(PlaylistThumbnail thumbnails) {
        this.thumbnails = thumbnails;
    }
}
