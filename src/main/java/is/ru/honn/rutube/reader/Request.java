/*************************************************************************************************
 *
 * Request.java - The Request class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

/**
 * API for a component that handles requests
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
public interface Request
{
    String getRequest(String url) throws ReaderException;
    String getFileContent(String fileName) throws ReaderException;
}