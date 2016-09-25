/*************************************************************************************************
 *
 * Reader.java - The Reader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

/**
 * API for a RuTube reader
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public interface Reader {
    Object read();
    Object parse(String content);
    void setURI(String URI);
    void setReadHandler(ReadHandler readHandler);
}