package io.floofdoggo.youtubeplaylistscanner.DAO.entity;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Column(unique = true)
    @Length(min = 6, max = 40, message = "Your login must have at least 6 characters.")
    private String username;
    @NotNull(message = "You must enter your password.")
    @Length(min = 6, message = "Your password must have at least 6 characters.")
    private String password;
    @NotNull(message = "You must enter your email address.")
    @Email
    private String email;
    private Integer role;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private Set<PlaylistEntity> playlistEntities;

    public UserEntity(String username, String password, String email, Integer role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.playlistEntities = new HashSet<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Set<PlaylistEntity> getPlaylistEntities() {
        return playlistEntities;
    }

    public void setPlaylistEntities(Set<PlaylistEntity> playlistEntities) {
        this.playlistEntities = playlistEntities;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", playlistEntities=" + playlistEntities +
                '}';
    }
}
