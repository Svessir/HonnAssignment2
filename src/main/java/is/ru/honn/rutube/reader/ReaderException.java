/*************************************************************************************************
 *
 * ReaderException.java - The ReaderException class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

/**
 * Exception dedicated to reader errors
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public class ReaderException extends RuntimeException
{
    public ReaderException()
    {
        super();
    }

    public ReaderException(String message)
    {
        super(message);
    }

    public ReaderException(String message, Throwable cause)
    {
        super(message, cause);
    }
}