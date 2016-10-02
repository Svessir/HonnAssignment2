/*************************************************************************************************
 *
 * ObserverUserServiceTest.java - The ObserverUserServiceTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.observer;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.mock.MockUserServiceObserver;
import is.ru.honn.rutube.service.UserService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Tests Observer functionality
 *
 * @author Kári
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:observer-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ObserverUserServiceTest {

    @Autowired
    MockUserServiceObserver observer;

    @Autowired
    UserService userService;

    private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(this.outputStreamContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setOut(null);
    }

    @Test
    public void TestUserInsert() {
        // Output stream should be empty
        userService.registerObserver(observer);
        assertEquals("", outputStreamContent.toString());

        // Adding user should cause the userservice to notify observers
        User user = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
        userService.addUser(user);

        // MockUserServiceObserver should have printed user.toString()
        assertEquals(user.toString() + "\r\n", outputStreamContent.toString());
    }
}