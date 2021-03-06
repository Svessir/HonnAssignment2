/*************************************************************************************************
 *
 * AbstractReader.java - The AbstractReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson.
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;
import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Stub implementation for a video service
 *
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class VideoServiceStub implements VideoService {

    private UserService userService;

    private Collection<Video> videoCollection = new ArrayList<Video>();

    public VideoServiceStub() {
    }

    /**
     * Gets a single video by id
     *
     * @param videoId The id of the video being retrieved.
     * @return Video object if found else null.
     */
    @Override
    public Video getVideo(int videoId) {
        for(Video vd : videoCollection){
            if(vd.getVideoId() == videoId){
                return vd;
            }
        }
        return null;
    }

    /**
     * Gets all videos authored by a user
     *
     * @param userId The id of the user who's videos are being retrieved.
     * @return All videos authored by a user.
     */
    @Override
    public List<Video> getVideosbyUser(int userId) {
        for(User user : userService.getUsers()) {
            if(user.getUserId() == userId)
                return user.getVideos();
        }

        return new ArrayList<Video>();
    }

    /**
     * Adds a video to the service
     *
     * @param video The video being added
     * @param userId The id of the user who authors the video being added.
     * @return True if video could be added with given userId else false.
     * @throws ServiceException On duplicate add.
     */
    @Override
    public boolean addVideo(Video video, int userId) throws ServiceException {
        User user = userService.getUser(userId);
        if(user != null) {
            videoInsertCheck(video);
            videoCollection.add(video);
            user.assignVideoToUser(video);
            return true;
        }
        return false;
    }

    /**
     * Set a user service for this video service
     *
     * @param userService The user service being set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Checks whether a video can be added to the service.
     *
     * @param video The video being added.
     * @throws ServiceException If video cannot be added to the service.
     */
    private void videoInsertCheck(Video video) throws ServiceException {
        if(video ==  null){
            throw new ServiceException("Could not add user to videoService. Null cannot be added.");
        }
        for(Video vs : videoCollection){
            if(vs.equals(video)) {
                throw new ServiceException("Could not add video to videoService, duplicate add.");
            }
        }
    }
}
