/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.rssfeedreader.entities;

/**
 *
 * @author gustavo
 */
public class Image {
     String url;
    String title;
    String link;
    // 3 optional elements
    String width;
    String height;
    String description;
    
    public String getURL() {
        return url;
    }
    
    public void setURL(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public String toString(){
        return "Image [url=" + url + ", title=" + title + ", link=" + link + ", width=" + width + ", height="
                + height + ", description=" + description + "]";
    }
}
