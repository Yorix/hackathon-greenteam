package org.hillel.hackatongreenteam.controller.dto;

public class UserDto {
    private int id;
    private String name;
    private String email;
    private String avatarPictureFilename;

    public UserDto(int id, String name, String email, String avatarPictureFilename) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatarPictureFilename = avatarPictureFilename;
    }

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

    public String getAvatarPictureFilename() {
        return avatarPictureFilename;
    }

    public void setAvatarPictureFilename(String avatarPictureFilename) {
        this.avatarPictureFilename = avatarPictureFilename;
    }
}
