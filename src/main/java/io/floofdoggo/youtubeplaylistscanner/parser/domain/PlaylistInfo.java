package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class PlaylistInfo {

    private String playlistId;
    private String title;
    private String publishedAt;

    public PlaylistInfo(String playlistId, String title, String publishedAt) {
        this.playlistId = playlistId;
        this.title = title;
        this.publishedAt = publishedAt;
    }

    public PlaylistInfo() {
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "PlaylistInfo{" +
                "playlistId='" + playlistId + '\'' +
                ", title='" + title + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
