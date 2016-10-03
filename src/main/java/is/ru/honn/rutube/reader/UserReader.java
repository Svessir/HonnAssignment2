/*************************************************************************************************
 *
 * UserReader.java - The UserReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;
/**
 * Component that extracts user objects from data.
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public class UserReader extends AbstractReader {

    private Reader videoReader;

    /**
     *
     * @param videoReader Reader to parse videos
     */
    public UserReader(Reader videoReader){
        this.videoReader = videoReader;
    }

    /**
     *
     * Walks through the json String and maps it to lists of users, which all contain 1 or more videos.
     *
     * @param content Json string with list of users, see http://mockaroo.com/f13b8200/download?count=1&key=e79a3650
     * @return Object which is a list of users.
     */
    public Object parse(String content) {
        //root object
        JSONObject jsonObject = (JSONObject) JSONValue.parse(content);

        // Get apiResults, this is an array so get the first (and only) item
        JSONArray apiResults = (JSONArray) jsonObject.get("apiResults");
        JSONObject jTmp = (JSONObject) apiResults.get(0);

        JSONArray jUsers = (JSONArray) jTmp.get("users");
        List<User> users = new ArrayList<>();

        jUsers.stream().forEach(jUser1 -> {
            JSONObject jUser = (JSONObject) jUser1;
            int userId = getInt(jUser, "userId");
            User user = new User(
                    userId,
                    (String) jUser.get("firstName"),
                    (String) jUser.get("lastName"),
                    (String) jUser.get("email"),
                    (String) jUser.get("displayName"),
                    (String) jUser.get("birthdate"));

            JSONArray jVideos = (JSONArray) jUser.get("videos");
            Object jvids = videoReader.parse(jVideos.toString());
            List<Video> videos = (List<Video>) jvids;
            user.setVideos(videos);

            users.add(user);
        });

        if(readHandler != null) {
            int i = 0;
            for(User user : users)
                readHandler.read(i++, user);
        }

        return users;
    }

}
