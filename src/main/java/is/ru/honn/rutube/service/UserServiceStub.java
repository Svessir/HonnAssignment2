/*************************************************************************************************
 *
 * AbstractReader.java - The AbstractReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson.
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub component for a user service
 *
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class UserServiceStub implements UserService {

    ArrayList<User> userCollection = new ArrayList<User>();
    ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     *
     *
     * @param user The user being added to the service
     * @return The Id of the user being added
     * @throws ServiceException On duplicate add or null
     */
    @Override
    public int addUser(User user) throws ServiceException {
        userInsertCheck(user);
        userCollection.add(user);
        return user.getUserId();
    }

    /**
     * Retrieves a single user from the service identified by the userId.
     *
     * @param userId The id of the user being retreived
     * @return The user identified by the userId else null
     */
    @Override
    public User getUser(int userId) {
        for(User us : userCollection){
            if(us.getUserId() == userId){
                return us;
            }
        }
        return null;
    }

    /**
     * Returns all Users maintained by the service.
     *
     * @return A list of users contained within the service
     */
    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userCollection);
    }

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
     * Checks whether a user can be added to the service.
     *
     * @param user The user being added.
     * @throws ServiceException If user cannot be added to the service.
     */
    private void userInsertCheck(User user) throws ServiceException{
        if(user == null){
            throw new ServiceException("Could not add user to userService. Null cannot be added.");
        }
        for(User us : userCollection){
            if(us.equals(user)){
                throw new ServiceException("Could not add user to userService, duplicate add.");
            }
        }
    }

    /**
     * Notifies all observers of changes relevant to observers.
     */
    private void notifyObservers() {
        for(Observer observer : observers)
            observer.notifyObserver();
    }
}
