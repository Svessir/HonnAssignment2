package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Sverrir on 1.10.2016.
 */
public class UserServiceStubTest {
    User user1 = new User(1, "Karl", "Pilkington", "karlP@gmail.com", "karlP", "2007-12-03");
    User user2 = new User(2, "Sver", "Kronjene", "sverK@gmail.com", "sverK", "2007-12-03");


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUserTest() throws Exception {
        UserServiceStub stub = new UserServiceStub();
        assertEquals(0, stub.userCollection.size());
        stub.addUser(user1);
        assertEquals(1, stub.userCollection.size());
    }

    @Test
    public void getUserTest() {
        UserServiceStub stub =  new UserServiceStub();
        stub.addUser(user1);
        stub.addUser(user2);
        User user = stub.getUser(user1.getUserId());
        assertEquals(user1, user);
    }

    @Test
    public void getUsersTest(){
        UserServiceStub stub = new UserServiceStub();
        stub.addUser(user1);
        stub.addUser(user2);
        List<User> userList = stub.getUsers();
        assertEquals(stub.userCollection, userList);
    }
}