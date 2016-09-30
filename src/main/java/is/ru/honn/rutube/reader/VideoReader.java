/*************************************************************************************************
 *
 * VideoReader.java - The VideoReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import is.ru.honn.rutube.domain.Video;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Component that extracts video objects from data.
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public class VideoReader extends AbstractReader {

    public VideoReader(){System.out.println("Inside videoReader constructor." );}


    /**
     * Walks through a json array of videos and maps it to a object which is a list of videos.
     *
     * @param content Should be a json Array of videos. see http://mockaroo.com/f13b8200/download?count=1&key=e79a3650
     * @return Object which is a list of videos.
     */
    public Object parse(String content){

        JSONArray jVideos = (JSONArray) JSONValue.parse(content);
        List<Video> videos = new ArrayList<>();

        jVideos.stream().forEach(jVideo -> {
            JSONObject jVid = (JSONObject) jVideo;
            int videoId = getInt(jVid, "videoId");

            Video video = new Video(
                    videoId,
                    (String) jVid.get("title"),
                    (String) jVid.get("description"),
                    (String) jVid.get("src"),
                    (String) jVid.get("type"),
                    (List<String>) jVid.get("tags")
            );
            videos.add(video);
        });

        return videos;
    }
}