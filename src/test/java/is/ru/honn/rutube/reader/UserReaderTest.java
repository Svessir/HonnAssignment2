/*************************************************************************************************
 *
 * UserReaderTest.java - The UserReaderTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.mock.MockReadHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Tests Reader functionality
 *
 * @author Sverrir
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:user-reader-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserReaderTest {

    @Autowired
    @Qualifier("userReader")
    private Reader userReader;

    @Autowired
    private ReadHandler readHandler = new MockReadHandler();

    private String invalidUri = "http:\\\\mockaroo.com/f13b8200/download?count=1&key=e79a3650";

    private String validUri = "http://mockaroo.com/f13b8200/download?count=1&key=e79a3650";

    private String invalidUriErrorMessage = "The URI set for reader is invalid.";

    private String readHandlerErrorMessage = "Read aborted: readHandler not set.";

    @Test
    public void readHandlerMissingTest() {
        // See if reader throws exception with no readHandler
        try
        {
            userReader.setURI(validUri);
            userReader.read();
            fail("Setting no readHandler before read did not cause exception to be thrown");
        }
        catch (ReaderException rex)
        {
            assertEquals(readHandlerErrorMessage, rex.getMessage());
        }
    }

    @Test
    public void userReadTest() {
        userReader.setReadHandler(readHandler);
        try
        {
            userReader.setURI(null);
            userReader.read();
            fail("Setting null URI to reader did not cause exception to be thrown.");
        }
        catch (ReaderException rex) {
            assertEquals(invalidUriErrorMessage, rex.getMessage());
        }

        try
        {
            userReader.setURI(invalidUri);
            userReader.read();
            fail("Setting invalid URI to reader did not cause exception to be thrown.");
        }
        catch (ReaderException rex) {
            assertEquals(invalidUriErrorMessage, rex.getMessage());
        }

        try
        {
            userReader.setURI(validUri);
            List<User> userList = (List<User>)userReader.read();

            // mockRequest has one user in its read "file", reader should return one user
            assertEquals(userList.size(), 1);
        }
        catch (Exception rex) {
            fail("Setting valid URI to reader caused an exception to be thrown: " + rex.getMessage());
        }
    }
}