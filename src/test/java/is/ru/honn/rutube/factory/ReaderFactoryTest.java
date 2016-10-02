/*************************************************************************************************
 *
 * ReaderFactoryTest.java - The ReaderFactoryTest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.factory;

import is.ru.honn.rutube.factory.ReaderFactory;
import is.ru.honn.rutube.reader.Reader;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests ReaderFactory functionality
 *
 * @author Sverrir
 * @version 1.0, 01 okt. 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:reader.xml")
public class ReaderFactoryTest extends TestCase {
    @Autowired
    @Qualifier("mockReader")
    private Reader reader;

    @Test
    public void FactoryReadXmlTest(){
        // Should retrieve mockReader
        ReaderFactory readerFactory = new ReaderFactory();
        Reader factoryReader = readerFactory.getReader("mockReader");
        assertEquals(reader.getClass(), factoryReader.getClass());
    }
}