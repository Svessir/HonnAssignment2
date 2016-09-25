/*************************************************************************************************
 *
 * Video.java - The Video class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.domain;

import java.util.List;

/**
 * Object that holds all relevant information
 * about a RuTube video.
 *
 * @author Sverrir
 * @version 1.0, 21 sep. 2016
 */
public class Video {

    int videoId;
    String title;
    String description;
    String source;
    String videoType;
    List<String> tags;

    public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.source = source;
        this.videoType = videoType;
        this.tags = tags;
    }

    public void addTag(String tag){
        tags.add(tag);
    }
}