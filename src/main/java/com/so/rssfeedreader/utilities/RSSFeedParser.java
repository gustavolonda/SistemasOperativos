/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.so.rssfeedreader.utilities;

import com.so.rssfeedreader.entities.Feed;
import com.so.rssfeedreader.entities.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.stream.XMLEventReader;
import com.so.rssfeedreader.entities.Item;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;


/**
 *
 * @author GoFor2014
 */
public class RSSFeedParser {
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";
    static final String IMAGE = "image";
    static final String URL = "url";
    
    final URL url;
    
    public RSSFeedParser(String feedURL) throws MalformedURLException {
        this.url = new URL(feedURL);
    }
    
    public Feed readFeed() throws XMLStreamException, IOException {
        Feed feed = null;
        boolean isFeedHeader = true;
        //// set header values to the empty String
        String description = "";
        String title = "";
        String link = "";
        String language = "";
        String copyright = "";
        String author = "";
        String pubdate = "";
        String guid = "";
        String imageURL = "";
        
        //// create a new XMLInputFactory
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        //// setup a new event reader
        InputStream in = read();
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
        //// read the XML document
        while(eventReader.hasNext()){
            XMLEvent event = eventReader.nextEvent();
            if(event.isStartElement()){
                String localPart = event.asStartElement().getName().getLocalPart();
                switch(localPart){
                    case IMAGE:
                       // create feed once while if image element occurs
                        if(isFeedHeader){
                            isFeedHeader = false;
                            feed = new Feed(title,link,description,language,
                                copyright,pubdate);
                        }
                        event = eventReader.nextEvent();
                        break;
                    case URL:
                        imageURL = getCharacterData(event, eventReader);
                        break;
                    case TITLE:
                        title = getCharacterData(event, eventReader);
                        break;
                    case DESCRIPTION:
                        description = getCharacterData(event, eventReader);
                        break;
                    case LINK:
                        link = getCharacterData(event, eventReader);
                        break;
                    case GUID:
                        guid = getCharacterData(event, eventReader);
                        break;
                    case LANGUAGE:
                        language = getCharacterData(event, eventReader);
                        break;
                    case AUTHOR:
                        author = getCharacterData(event, eventReader);
                        break;
                    case PUB_DATE:
                        pubdate = getCharacterData(event, eventReader);
                        break;
                    case COPYRIGHT:
                        copyright = getCharacterData(event, eventReader);
                        break;
                    case ITEM:
                        // create feed once while first item element occurs
                        if(isFeedHeader){
                            isFeedHeader = false;
                            feed = new Feed(title,link,description,language,
                                copyright,pubdate);
                        }
                        event = eventReader.nextEvent();
                        break;
                } 
            } else if (event.isEndElement()){
                if(event.asEndElement().getName().getLocalPart() == IMAGE){
                    Image image = feed.getImage();
                    image.setTitle(title);
                    image.setLink(link);
                    image.setURL(imageURL);
                } else if (event.asEndElement().getName().getLocalPart() == ITEM){
                    Item msg = new Item();
                    msg.setAuthor(author);
                    msg.setDescription(description);
                    msg.setGuid(guid);
                    msg.setLink(link);
                    msg.setTitle(title);
                    msg.setUrlImagen(imageURL);
                    feed.getMessage().add(msg);
                    event = eventReader.nextEvent();
                }
            }
        }
        return feed;
    }

    private InputStream read() throws IOException {
        URLConnection uc = url.openConnection();
        uc.addRequestProperty("User-Agent", 
        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        return uc.getInputStream();
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if(event instanceof Characters){
            result = event.asCharacters().getData();
        }
        return result;
    }
    
}
