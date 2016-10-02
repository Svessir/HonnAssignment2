/*************************************************************************************************
 *
 * ReaderTest.java - The ReaderTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests Reader functionality
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:user-reader-test.xml")
public class ReaderTest extends TestCase {
    @Autowired
    @Qualifier("userReader")
    private Reader reader;

    @Test
    public void readerTest(){
    }
}