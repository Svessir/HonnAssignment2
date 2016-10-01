/*************************************************************************************************
 *
 * Observer.java - The Observer class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.observer;

/**
 * API for an observer in an observer pattern
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
public interface Observer {
    void notifyObserver();
}