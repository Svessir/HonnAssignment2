/*************************************************************************************************
 *
 * ReaderFactory.java - The ReaderFactory class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.factory;

import is.ru.honn.rutube.reader.Reader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Component that outputs RuTube readers
 *
 * @author Sverrir
 * @version 1.0, 28 sep. 2016
 */
public class ReaderFactory {

    /**
     *
     * @param readerName identification name of the reader being retrieved.
     * @return Reader object that identifies to the readerName.
     * @throws FactoryException If no reader is found with the supplied identification name.
     */
    public Reader getReader(String readerName) throws FactoryException {
        try
        {
            ApplicationContext context = new FileSystemXmlApplicationContext("classpath:service.xml");
            Reader reader = (Reader) context.getBean("userService");
            return reader;
        }
        catch (BeansException bex) {
            FactoryException fex = new FactoryException(bex.getMessage(), bex.getCause());
            throw  fex;
        }
    }
}