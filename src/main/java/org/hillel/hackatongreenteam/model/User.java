package org.hillel.hackatongreenteam.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by User on 23.02.2019.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "avatar_picture_filename")
    private String avatarPictureFilename;

    @NotNull
    @Column(name = "is_admin")
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarPictureFilename() {
        return avatarPictureFilename;
    }

    public void setAvatarPictureFilename(String avatarPictureFilename) {
        this.avatarPictureFilename = avatarPictureFilename;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
