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
public class Video{

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

    /**
     * Adds a new tag to this video. If the tag already exists
     * then this method does nothing.
     *
     * @param tag The tag being added to this video.
     */
    public void addTag(String tag){
        if(!tags.contains(tag))
            tags.add(tag);
    }

    /**
     *
     * @return This video's unique id.
     */
    public int getVideoId() {
        return videoId;
    }

    /**
     *
     * @return This video's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return This video's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return This video's source.
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @return This video's type
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * Checks if Object o is this video by comparing their IDs.
     *
     * @param o The objects being tested for equality.
     * @return True if object is equal to this video, else false.
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Video))
            return false;
        Video v = (Video) o;
        return videoId != v.videoId ? false : true;
    }

    /**
     *
     * @return String containing this video type and title.
     */
    public String toString(){
        return videoType + " : " + title;
    }
}