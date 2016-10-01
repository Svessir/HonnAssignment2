/*************************************************************************************************
 *
 * ServiceFactory.java - The ServiceFactory class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.factory;

import is.ru.honn.rutube.service.UserService;
import is.ru.honn.rutube.service.VideoService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Component that outputs RuTube services
 *
 * @author Sverrir
 * @version 1.0, 28 sep. 2016
 */
public class ServiceFactory {

    private static UserService userService;
    private static VideoService videoService;

    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {

        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:service.xml");

        try
        {
            userService = (UserService) context.getBean("userService");
            videoService = (VideoService) context.getBean("videoService");
        }
        catch (BeansException bex) {
            bex.printStackTrace();
        }

    }

    /**
     * Gets the UserService for RuTube
     *
     * @return RuTube's UserService.
     */
    public UserService getUserService() {

        return userService;
    }

    /**
     * Gets the VideoService for RuTube
     *
     * @return RuTube's VideoService.
     */
    public VideoService getVideoService() {
        return videoService;
    }
}