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
import com.so.rssfeedreader.entities.ValoresEstaticos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author gustavo
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
     private  List<Feed> listaFeed = new ArrayList<Feed>(ValoresEstaticos.listaFeed2);
     static final List<Feed> listaFeed2 = new ArrayList<Feed>();
    private Image image = new Image();
 @ManagedProperty(value="#{rssfeedreaderBo}")
     private RssfeedreaderBo rssfeedreaderBo=new RssfeedreaderImpBo();
 

    public void readFeed(){ 
     
     Feed fee=new Feed(title,link,description,language,
                                copyright,pubDate);
     
     fee=rssfeedreaderBo.readerFeed(link);
     ValoresEstaticos.listaFeed2.add(fee);
     
     
     listaFeed.clear();
     listaFeed.addAll(ValoresEstaticos.listaFeed2);
       links.add(title);
        
        setTitle(fee.getMessage().get(1).getTitle());
       setDescription(fee.getDescription());
       setEntries(fee.getMessage());
       HashSet<Item> hashSet = new HashSet<Item>(getEntries());
		getEntries().clear();
		getEntries().addAll(hashSet);
       setLanguage(fee.getLaunguage());
       setPubDate(fee.getPubDate());
       setCopyright(fee.getCopyright());
       setImage(fee.getImage());
       setUrlImagen(fee.getMessage().get(1).getUrlImagen());
       setDescriptionNoticia(fee.getMessage().get(1).getDescription());
      // System.out.print(fee.toString());
       //System.err.print(rssfeedreaderBo.readerFeed(link).getEntries().get(0).getUrlImgen());
       

     
     

      
         
     }
    public void iniciar(){ 
        while(true){
            new NewThread();
    try {
      // espera un tiempo para que terminen los otros hilos
      Thread.sleep(3000);
      System.out.printf("Hola");
    } catch (InterruptedException e) {
      System.out.println("Interrupcion del hilo principal");
    }
    System.out.println("Sale del hilo principal.");
        
        }
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
  @PostConstruct
   public void init(){
       new NewThread();
    try {
      // espera un tiempo para que terminen los otros hilos
      Thread.sleep(500);
    } catch (InterruptedException e) {
      System.out.println("Interrupcion del hilo principal");
    }
    System.out.println("Sale del hilo principal.");
       
   } 
   
  
    
}
 class NewThread implements Runnable {
 private  List<Feed> listaFeed = new ArrayList<Feed>(ValoresEstaticos.listaFeed2);
 private  List<Feed> listaFeed2 = new ArrayList<Feed>(ValoresEstaticos.listaFeed2);
 private RssfeedreaderBo rssfeedreaderBo=new RssfeedreaderImpBo();
 public Thread t;
  NewThread() {
    
    t = new Thread(this);
    
    t.start(); // Comienza el hilo
    
  }
  // Este es el punto de entrada del hilo.
  public void run() {
      List<Feed> listaFeed3 = new ArrayList<Feed>();
      Feed feed;
    try {

      for(int i = 0; i > listaFeed.size(); i++) {
        feed=new Feed();
        feed=rssfeedreaderBo.readerFeed(listaFeed.get(i).getLink());
        listaFeed2.add(feed);
        Thread.sleep(10);
      }
      ValoresEstaticos.listaFeed2.clear();
      ValoresEstaticos.listaFeed2.addAll(listaFeed2);
    }

    catch (InterruptedException e) {
      System.out.println("Interrupcion del hilo hijo");
    }
    System.out.println("Sale del hilo hijo" );
  }
}
