/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.rssfeedreader.bo;

import com.so.rssfeedreader.entities.Feed;

/**
 *
 * @author gustavo
 */
public interface RssfeedreaderBo {
    public Feed readerFeed(String link);
}
