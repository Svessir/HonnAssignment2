/*************************************************************************************************
 *
 * VideoServiceTest.java - The VideoServiceTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Component description
 *
 * @author Kári
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class VideoServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;


    @Before
    public void Setup(){

    }

    @Test
    public void addVideoTest(){
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        userService.addUser(user1);
        Video video1 = new Video(1, "Onka Judge", "Onka Judge audition", "https://www.youtube.com/watch?v=qTfVNOXNOSg", "video", new ArrayList<String>());
        int ret = videoService.addVideo(video1, 1);
        assertEquals(1, ret);
        try{
            videoService.addVideo(null, 1);
            fail();
        }catch (ServiceException sx){
            assertEquals("Could not add user to videoService. Null cannot be added.", sx.getMessage());
        }
        try{
            videoService.addVideo(video1, 1);
            fail();
        }catch (ServiceException sx) {
            assertEquals("Could not add video to videoService, duplicate add.", sx.getMessage());
        }

    }

    @Test
    public void getVideoTest(){
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        userService.addUser(user1);
        Video video1 = new Video(1, "Onka Judge", "Onka Judge audition", "https://www.youtube.com/watch?v=qTfVNOXNOSg", "video", new ArrayList<String>());
        int ret = videoService.addVideo(video1, 0);
        assertEquals(0, ret);
        videoService.addVideo(video1, 1);
        Video getVideo = videoService.getVideo(1);
        assertEquals(video1, getVideo);
        getVideo = videoService.getVideo(2);
        assertEquals(null, getVideo);
    }

    @Test
    public void getVideosByUserIdTest(){
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        userService.addUser(user1);
        User user2 = new User(2, "Sver", "Kronjene", "sverK@gmail.com", "sverK", "2007-12-03");
        userService.addUser(user2);
        Video video1 = new Video(1, "Onka Judge", "Onka Judge audition", "https://www.youtube.com/watch?v=qTfVNOXNOSg", "video", new ArrayList<String>());
        Video video2 = new Video(2, "Family Guy", "Family Guy - Best of Season 13", "https://www.youtube.com/watch?v=sAj3UR2S8lo", "video", new ArrayList<String>());
        Video video3 = new Video(3, "David Gilmour", "David Gilmour-shine on you crazy diamond (live acoustic)", "https://www.youtube.com/watch?v=0qjpOLj7WSY", "video", new ArrayList<String>());
        List<Video> userVideos = new ArrayList<Video>();
        userVideos.add(video1);
        userVideos.add(video2);
        videoService.addVideo(video1, 1);
        videoService.addVideo(video2, 1);
        videoService.addVideo(video3, 2);
        List<Video> videoByUserList =  videoService.getVideosbyUser(1);
        assertEquals(userVideos, videoByUserList);
    }


}
