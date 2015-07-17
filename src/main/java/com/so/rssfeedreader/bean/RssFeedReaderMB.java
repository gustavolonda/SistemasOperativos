/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.rssfeedreader.bean;

import com.so.rssfeedreader.bo.RssfeedreaderBo;
import com.so.rssfeedreader.bo.RssfeedreaderImpBo;
import com.so.rssfeedreader.entities.Feed;
import com.so.rssfeedreader.entities.FeedMessage;
import com.so.rssfeedreader.entities.Image;
import com.so.rssfeedreader.entities.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author ronny
 */
public class RssFeedReaderMB {

    /**
     * Creates a new instance of RssFeedReaderMB
     */
	private String title;
    private String link;
    private String description;
    private String descriptionNoticia;
    // optional elements
    private String language;
    private String copyright;
    private String pubDate;
    private String urlImagen;
    private List<Item> entries = new ArrayList<Item>();
    private static final List<String> links = new ArrayList<String>();
     private  List<Feed> listaFeed = new ArrayList<Feed>(listaFeed2);
     static final List<Feed> listaFeed2 = new ArrayList<Feed>();
    private Image image = new Image();
	@ManagedProperty(value="#{rssfeedreaderBo}")
	
    private RssfeedreaderBo rssfeedreaderBo=new RssfeedreaderImpBo();
 
    public void readFeed(){ 
     Feed fee=new Feed(title,link,description,language,
                                copyright,pubDate);
     
     fee=rssfeedreaderBo.readerFeed(link);
     listaFeed2.add(fee);
     listaFeed.clear();
     listaFeed.addAll(listaFeed2);
       links.add(title);
        
        
          
         
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<Item> getEntries() {
        return entries;
    }

    public void setEntries(List<Item> entries) {
        this.entries = entries;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public RssfeedreaderBo getRssfeedreaderBo() {
        return rssfeedreaderBo;
    }

    public void setRssfeedreaderBo(RssfeedreaderBo rssfeedreaderBo) {
        this.rssfeedreaderBo = rssfeedreaderBo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescriptionNoticia() {
        return descriptionNoticia;
    }

    public void setDescriptionNoticia(String descriptionNoticia) {
        this.descriptionNoticia = descriptionNoticia;
    }

    public static List<String> getLinks() {
        return links;
    }

    public  List<Feed> getListaFeed() {
        return listaFeed;
    }

    
    
    
}
