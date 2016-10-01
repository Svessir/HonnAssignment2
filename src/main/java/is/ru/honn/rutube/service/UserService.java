/*************************************************************************************************
 *
 * UserService.java - The UserService class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.observer.Subject;

import java.util.List;

/**
 * API for a user service
 *
 * @author Sverrir
 * @version 1.0, 21 sep. 2016
 */
public interface UserService extends Subject {
    int addUser(User user) throws ServiceException;
    User getUser(int userId);
    List<User> getUsers();
}