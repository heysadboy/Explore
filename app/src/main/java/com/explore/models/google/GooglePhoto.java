package com.explore.models.google;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class GooglePhoto implements Serializable{
    private int height;
    private int width;

    @JsonProperty("html_attributions")
    private List<String> htmlAttributions;

    @JsonProperty("photo_reference")
    private String photoReference;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }
}
