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
 * that observes a subject that notifies with objects
 * of class T
 *
 * @param <T> The class of the object a observer will be notified with
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
public interface Observer<T> {
    void notifyObserver(T object);
}