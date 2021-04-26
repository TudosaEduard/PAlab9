package com.compulsory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column (name = "id")
    @GeneratedValue (generator = "incrementor")
    @GenericGenerator(name = "incrementor" , strategy = "increment")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column (name = "releaseDate")
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String relaseDate) {
        this.releaseDate = relaseDate;
    }

    @Column (name = "duration")
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column (name = "score")
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
