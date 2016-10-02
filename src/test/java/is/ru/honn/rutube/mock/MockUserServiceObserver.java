/*************************************************************************************************
 *
 * MockUserServiceObserver.java - The MockUserServiceObserver class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.mock;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.observer.Observer;

/**
 * Component that mocks observer.
 *
 * @author Kári
 * @version 1.0, 02 okt. 2016
 */
public class MockUserServiceObserver implements Observer<User>{

    @Override
    public void notifyObserver(User object) {
        System.out.println(object);
    }

}