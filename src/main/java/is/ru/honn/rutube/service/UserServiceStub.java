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
import java.util.Collection;
import java.util.List;

/**
 * Stub component for a user service
 *
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class UserServiceStub implements UserService {

    Collection<User> userCollection = new ArrayList<User>();

    @Override
    public int addUser(User user) throws ServiceException {
        userInsertCheck(user);
        userCollection.add(user);
        return user.getUserId();
    }

    @Override
    public User getUser(int userId) {
        for(User us : userCollection){
            if(us.getUserId() == userId){
                return us;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userCollection;
    }

    private void userInsertCheck(User user) throws ServiceException{
        if(user == null){
            throw new NullPointerException();
        }
        for(User us : userCollection){
            if(us.equals(user)){
                throw new ServiceException("Could not add user to userService, duplicate add");
            }
        }
    }
}
