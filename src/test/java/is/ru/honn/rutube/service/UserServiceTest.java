/*************************************************************************************************
 *
 * UserServiceTest.java - The UserServiceTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Component description
 *
 * @author Kári
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:user-service.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void Setup(){

    }

    @Test
    public void addUserTest(){
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        User user2 = new User(2, "Sver", "Kronjene", "sverK@gmail.com", "sverK", "2007-12-03");
        Assert.assertEquals(new ArrayList<User>(), userService.getUsers());
        userService.addUser(user1);
        User newUser = userService.getUser(1);
        Assert.assertEquals(user1, newUser);
    }

  /*  @Test
    public void getUserTest(){

    }

    @Test
    public void getUsersTest(){

    }*/
}