/*************************************************************************************************
 *
 * AbstractReader.java - The AbstractReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson.
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class VideoServiceStub implements VideoService {

    Collection<Video> videoCollection = new ArrayList<Video>();

    @Override
    public Video getVideo(int videoId) {
        return null;
    }

    @Override
    public List<Video> getVideosbyUser(int userId) {
        return null;
    }

    @Override
    public int addVideo(Video video, int userId) throws ServiceException {
        return 0;
    }
}
