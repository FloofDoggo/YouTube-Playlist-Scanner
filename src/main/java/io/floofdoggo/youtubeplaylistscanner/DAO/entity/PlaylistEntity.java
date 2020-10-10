package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String playlist_id;
    private String name;
    private String playlist_thumbnail;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlists")
    Set<VideoEntity> videos = new HashSet<>();

    public PlaylistEntity(String playlist_id, String name, String playlist_thumbnail) {
        this.playlist_id = playlist_id;
        this.name = name;
        this.playlist_thumbnail = playlist_thumbnail;
    }

    public PlaylistEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(String playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaylist_thumbnail() {
        return playlist_thumbnail;
    }

    public void setPlaylist_thumbnail(String playlist_thumbnail) {
        this.playlist_thumbnail = playlist_thumbnail;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public Set<VideoEntity> getVideos() {
        return videos;
    }

    public void setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
    }
}
