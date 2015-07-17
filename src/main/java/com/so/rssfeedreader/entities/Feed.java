/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.so.rssfeedreader.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GoFor2014
 */
public class Feed {
    // 3 requirement elements
    final String title;
    final String link;
    final String description;
    // optional elements
    final String language;
    final String copyright;
    final String pubDate;
    
    final List<Item> entries = new ArrayList<Item>();
    final Image image = new Image();
    
    public Feed(String title, String link, String description, String language, String copyright, String pubDate){
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    public Feed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Image getImage() {
        return image;
    }
    
    public List<Item> getMessage(){
        return entries;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getLink(){
        return link;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getLaunguage(){
        return language;
    }
    
    public String getCopyright(){
        return copyright;
    }
    
    public String getPubDate(){
        return pubDate;
    }
    
    public String toString(){
        return "Feed [copyright=" + copyright + ", description=" + description + ", language"
                + language + ", link=" + link + ", pubDate=" + pubDate + ", title=" + title + "]";
    }
}
