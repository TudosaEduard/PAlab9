package com.compulsory.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table (name ="genres")
public class Genre {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor" , strategy = "increment")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
