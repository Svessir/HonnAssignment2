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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests UserService functionality
 *
 * @author Kári
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void Setup(){

    }

    @Test
    public void addUserTest(){
        // Adding a user to the userService list.
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        userService.addUser(user1);

        // Testing if adding a user that already exists fails.
        try{
            userService.addUser(user1);
            fail();
        }catch (ServiceException sx){
            assertEquals("Could not add user to userService, duplicate add.", sx.getMessage());
        }

        // Testing if adding a null user fails.
        try{
            userService.addUser(null);
            fail();
        }catch (ServiceException sx) {
            assertEquals("Could not add user to userService. Null cannot be added.",sx.getMessage());
        }
    }

    @Test
    public void getUserTest(){
        // Adding a user to the userService list.
        User user2 = new User(1, "Sver", "Kronjene", "sverK@gmail.com", "sverK", "2007-12-03");
        userService.addUser(user2);

        // Testing if getting a user that does not exits fails.
        User newUser = userService.getUser(2);
        assertEquals(null, newUser);

        // Testing if getting a user that exists works.
        newUser = userService.getUser(1);
        assertEquals(user2, newUser);
    }

    @Test
    public void getUsersTest(){
        List<User>  userList = new ArrayList<User>();
        User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        User user2 = new User(2, "Sver", "Kronjene", "sverK@gmail.com", "sverK", "2007-12-03");

        // Adding users to userService list and a temp list.
        userService.addUser(user1);
        userList.add(user1);
        userService.addUser(user2);
        userList.add(user2);

        // Testing if userService list and temp list are the same.
        assertEquals(userList, userService.getUsers());
    }
}