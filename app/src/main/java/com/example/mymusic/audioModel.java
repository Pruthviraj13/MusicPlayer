package com.example.mymusic;

import java.io.Serializable;

public class audioModel implements Serializable {
    String path;
    String duration;
    String title;

    public audioModel(String path, String duration, String title) {
        this.path = path;
        this.duration = duration;
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
