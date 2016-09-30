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
public class Video implements Comparable<Video>{

    private int videoId;
    private String title;
    private String description;
    private String source;
    private String videoType;
    private List<String> tags;

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

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Override
    public int compareTo(Video o) {
        if(this.videoId != o.videoId){return -1;}
        if(this.title != o.title){return -1;}
        if(this.description != o.description){return -1;}
        if(this.source != o.source){return -1;}
        if(this.videoId != o.videoId){return -1;}
        if(this.tags != o.tags){return -1;}
        return 0;
    }
}