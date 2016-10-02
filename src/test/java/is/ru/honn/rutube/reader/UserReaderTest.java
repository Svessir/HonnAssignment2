/*************************************************************************************************
 *
 * UserReaderTest.java - The UserReaderTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    Reader userReader;

    @Autowired
    ReadHandler readHandler;

    @Test
    public void readHandlerMissingTest() {
        // See if reader throws exception with no readHandler
        try
        {
            userReader.read();
            fail();
        }
        catch (ReaderException rex)
        {
            assertEquals("Read aborted: readHandler not set.", rex.getMessage());
        }
    }

    @Test
    public void URIWrongTest() {

    }
}