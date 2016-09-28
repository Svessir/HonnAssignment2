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
 * 
 * @author Kári
 * @version 1.0, 21 sep. 2016
 */
public class UserServiceStub implements UserService {

    Collection<User> userCollection = new ArrayList<User>();

    @Override
    public int addUser(User user) throws ServiceException {
        userCollection.add(user);
        return user.getUserId();
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userCollection;
    }
}
