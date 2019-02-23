package org.hillel.hackatongreenteam.model;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 23.02.2019.
 */
@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "date_created")
    private Date dateCreated;

    @NotNull
    @Column(name = "content")
    private String content;

    @Nullable
    @Column(name = "image_filename")
    private String imageFilename;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="category_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
