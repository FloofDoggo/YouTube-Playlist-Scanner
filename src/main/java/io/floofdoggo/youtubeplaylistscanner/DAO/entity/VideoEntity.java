package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "video")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String video_id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private PlaylistEntity playlists;

    public VideoEntity(String video_id, String title) {
        this.video_id = video_id;
        this.title = title;
    }

    public VideoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PlaylistEntity getPlaylists() {
        return playlists;
    }

    public void setPlaylists(PlaylistEntity playlists) {
        this.playlists = playlists;
    }
}
