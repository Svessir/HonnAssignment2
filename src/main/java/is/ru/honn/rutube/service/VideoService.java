/*************************************************************************************************
 *
 * VideoService.java - The VideoService class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.Video;

import java.util.List;

/**
 * API for a video service
 *
 * @author Sverrir
 * @version 1.0, 21 sep. 2016
 */
public interface VideoService {
    Video getVideo(int videoId);
    List<Video> getVideosbyUser(int userId);
    int addVideo(Video video, int userId) throws ServiceException;
}