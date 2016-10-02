/*************************************************************************************************
 *
 * MockRequest.java - The MockRequest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.mock;

import is.ru.honn.rutube.reader.ReaderException;
import is.ru.honn.rutube.reader.Request;

/**
 * Component that mocks Request behavior
 *
 * @author Sverrir
 * @version 1.0, 02 okt. 2016
 */
public class MockRequest implements Request {

    private String workingURI;

    @Override
    public String getRequest(String url) throws ReaderException {
        if(url.equals("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650")) {
            return "";
        }
        else
            throw new ReaderException("Could not read resource: 404 Not Found.");
    }

    @Override
    public String getFileContent(String fileName) throws ReaderException {
        return null;
    }

    public void setWorkingURI(String workingURI) {
        this.workingURI = workingURI;
    }
}