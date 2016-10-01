/*************************************************************************************************
 *
 * FactoryException.java - The FactoryException class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.factory;

/**
 * Exception dedicated to Factory errors
 *
 * @author Sverrir
 * @version 1.0, 28 sep. 2016
 */
public class FactoryException extends RuntimeException {

    public FactoryException(){super();}

    public FactoryException(String message)
    {
        super(message);
    }

    public FactoryException(String message, Throwable cause)
    {
        super(message, cause);
    }
}