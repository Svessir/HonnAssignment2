/*************************************************************************************************
 *
 * ReadHandler.java - The ReadHandler class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

/**
 * API for a read handler
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public interface ReadHandler {
    void read(int count, Object object);
}