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

import java.util.ArrayList;
import java.util.List;

/**
 * Stub implementation for a user service
 *
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class UserServiceStub extends AbstractUserService {

    protected ArrayList<User> userCollection = new ArrayList<User>();

    /**
     * Adds a user to the service if the service does not
     * yet maintain the user.
     *
     * @param user The user being added to the service
     * @return True if user could be added else false.
     * @throws ServiceException On duplicate add or null
     */
    @Override
    public boolean addUser(User user) throws ServiceException {
        userInsertCheck(user);
        userCollection.add(user);
        notifyObservers(user);
        return true;
    }

    /**
     * Retrieves a single user from the service identified by the userId.
     *
     * @param userId The id of the user being retrieved
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
}
