/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.rssfeedreader.bo;

import com.so.rssfeedreader.entities.Feed;
import com.so.rssfeedreader.utilities.RSSFeedParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author gustavo
 */
public class RssfeedreaderImpBo implements RssfeedreaderBo{

    @Override
    public Feed readerFeed(String link) {
        RSSFeedParser rSSFeedParser = null;
        try {
            rSSFeedParser = new RSSFeedParser(link);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RssfeedreaderImpBo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return rSSFeedParser.readFeed();
        } catch (XMLStreamException ex) {
            Logger.getLogger(RssfeedreaderImpBo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RssfeedreaderImpBo.class.getName()).log(Level.SEVERE, null, ex);
        }
     return null;}
    
}
