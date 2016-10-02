/*************************************************************************************************
 *
 * AbstractUserService.java - The AbstractUserService class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.observer.Observer;

import java.util.ArrayList;

/**
 * Super layer type for common implementations
 * across all UserService implementations
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
public abstract class AbstractUserService implements UserService {

    ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * Registers observer to the service. If the observer is already registered
     * to the service then this method does nothing.
     *
     * @param observer The observer that wants to register to the service's observer pool
     */
    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    /**
     * Unregisters an observer from the service. If the observer is not already registered
     * to the service then this method does nothing.
     *
     * @param observer The observer that wants to unregister from the service's observer pool
     */
    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers of changes relevant to observers.
     */
    protected void notifyObservers(User user) {
        for(Observer observer : observers)
            observer.notifyObserver(user);
    }
}