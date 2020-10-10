package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Length(min = 6, max = 40, message = "Your login must have at least 6 characters.")
    private String username;
    @NotNull(message = "You must enter your password.")
    @Length(min = 6, message = "Your password must have at least 6 characters.")
    private String password;
    private Integer role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    Set<PlaylistEntity> playlists = new HashSet<>();

    public UserEntity(@NotNull @Length(min = 6, max = 40, message = "Your login must have at least 6 characters.") String username, @NotNull(message = "You must enter your password.") @Length(min = 6, message = "Your password must have at least 6 characters.") String password, Integer role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Set<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<PlaylistEntity> playlists) {
        this.playlists = playlists;
    }
}
