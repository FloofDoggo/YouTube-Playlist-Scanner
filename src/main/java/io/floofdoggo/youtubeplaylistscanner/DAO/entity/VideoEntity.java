package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private PlaylistEntity playlistEntity;
    private String title;
    private String uploaded_at;

    public VideoEntity(String title, String uploaded_at) {
        this.title = title;
        this.uploaded_at = uploaded_at;
    }

    public VideoEntity() {
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "id=" + id +
                ", playlistEntity=" + playlistEntity +
                ", title='" + title + '\'' +
                ", uploaded_at='" + uploaded_at + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlaylistEntity getPlaylistEntity() {
        return playlistEntity;
    }

    public void setPlaylistEntity(PlaylistEntity playlistEntity) {
        this.playlistEntity = playlistEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploaded_at() {
        return uploaded_at;
    }

    public void setUploaded_at(String uploaded_at) {
        this.uploaded_at = uploaded_at;
    }
}
