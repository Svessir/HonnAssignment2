/*************************************************************************************************
 *
 * Subject.java - The Subject class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.observer;

/**
 * API for Subject in an observer pattern
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
}