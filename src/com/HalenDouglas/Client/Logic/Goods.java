package com.HalenDouglas.Client.Logic;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by HNKNTOC on 28.07.2015.
 *
 */
public class Goods implements Serializable {
    private String name;
    private String id;
    private String collection;
    private String type;
    private String state;
    private int cost;
    private String imageDirectory = "src/res.image/no_image.png";

    public Goods(String name,String id,String collection, String type,String state, int cost,String imageDirectory) {
        this.name = name;
        this.id=id;
        this.collection = collection;
        this.type = type;
        this.state=state;
        this.cost = cost;
        this.imageDirectory = imageDirectory; //.getScaledInstance(101,130,1);
    }

    public Goods() {
    }


    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[ id="+id+", Name="+name+", Collection="+collection+", Type="+type+
                ", State="+state+", Cost="+cost+", Image"+ imageDirectory+" ]";
    }
}
