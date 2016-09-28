/*************************************************************************************************
 *
 * ServiceFactory.java - The ServiceFactory class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

/**
 * Component that outputs services
 *
 * @author Sverrir
 * @version 1.0, 28 sep. 2016
 */
public class ServiceFactory {

    public UserService getUserService() {
        return null;
    }

    public VideoService getVideoService() {
        return null;
    }
}