/*************************************************************************************************
 *
 * ReaderTest.java - The ReaderTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests Reader functionality
 *
 * @author Sverrir
 * @version 1.0, 02 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:reader-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ReaderTest {

    /*@Autowired
    private Reader reader;
*/
    @Test
    public void setReadHandler() {

    }
}