/*************************************************************************************************
 *
 * ServiceException.java - The ServiceException class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;


/**
 * Exception dedicated to RuTube service errors
 *
 * @author Sverrir
 * @version 1.0, 21 sep. 2016
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message,  Throwable cause) {
        super(message, cause);
    }
}