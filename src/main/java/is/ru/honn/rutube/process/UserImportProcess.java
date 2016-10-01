/*************************************************************************************************
 *
 * UserImportProcess.java - The UserImportProcess class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.process;
import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.factory.ReaderFactory;
import is.ru.honn.rutube.factory.ServiceFactory;
import is.ru.honn.rutube.reader.ReadHandler;
import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.service.UserService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Process that reads users from resource and imports them
 * to the UserService
 *
 * @author Sverrir
 * @version 1.0, 28 sep. 2016
 */
public class UserImportProcess extends RuAbstractProcess implements ReadHandler {

    private Logger logger = Logger.getLogger(getClass().getName());
    private MessageSource msg;
    private UserService userService;
    private Reader reader;

    /**
     * Acquire dependencies before the process starts.
     */
    @Override
    public void beforeProcess() {
        // Get logger process messages from the spring config file app.xml
        ApplicationContext appContext = new FileSystemXmlApplicationContext("classpath:app.xml");
        msg = (MessageSource) appContext.getBean("messageSource");

        ReaderFactory readerFactory = new ReaderFactory();

        userService = ServiceFactory.getInstance().getUserService();
        reader = readerFactory.getReader("userReader");

        /*
        Configure the reader such that it will read from the resource and use this process
        as a callback
        */
        reader.setURI(getProcessContext().getImportURL());
        reader.setReadHandler(this);

        logger.info(msg.getMessage("processbefore",
                new Object[] { getProcessContext().getProcessName() }, Locale.getDefault()));
    }

    /**
     * Read users from resource.
     */
    @Override
    public void startProcess() {
        logger.info(msg.getMessage("processstart",
                new Object[] { getProcessContext().getProcessName() }, Locale.getDefault()));

        // Start reading from resource
        reader.read();
    }

    /**
     * Log that process has end.
     */
    @Override
    public void afterProcess() {
        logger.info(msg.getMessage("processend",
                new Object[] { getProcessContext().getProcessName() }, Locale.getDefault()));
    }

    /**
     * Adds objects read by the Reader to the UserService if
     * the object is a User, else it does nothing.
     *
     * @param count
     * @param object Object read by reader.
     */
    @Override
    public void read(int count, Object object) {
        if(!(object instanceof User))
            return;

        User user = (User) object;
        System.out.println(user);
        userService.addUser(user);
    }
}