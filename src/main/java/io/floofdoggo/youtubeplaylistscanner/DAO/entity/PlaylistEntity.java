package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private String name;
    @NotNull(message = "The playlist must have its own code.")
    private String playlist_code;
    @OneToMany(mappedBy = "playlistEntity", cascade = CascadeType.ALL)
    private Set<VideoEntity> videoEntities;

    public PlaylistEntity(UserEntity userEntity, String name, String playlist_code) {
        this.userEntity = userEntity;
        this.name = name;
        this.playlist_code = playlist_code;
    }

    public PlaylistEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaylist_code() {
        return playlist_code;
    }

    public void setPlaylist_code(String playlist_code) {
        this.playlist_code = playlist_code;
    }

    public Set<VideoEntity> getVideoEntities() {
        return videoEntities;
    }

    public void setVideoEntities(Set<VideoEntity> videoEntities) {
        this.videoEntities = videoEntities;
    }

    @Override
    public String toString() {
        return "PlaylistEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", name='" + name + '\'' +
                ", playlist_code='" + playlist_code + '\'' +
                '}';
    }
}
