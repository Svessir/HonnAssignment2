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
    private String errorMessage;
    private String parseValue;

    @Override
    public String getRequest(String url) throws ReaderException {
        return mockRequestGetting(url);
    }

    @Override
    public String getFileContent(String fileName) throws ReaderException {
        return mockRequestGetting(fileName);
    }

    public void setWorkingURI(String workingURI) {
        this.workingURI = workingURI;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setParseValue(String parseValue) {
        this.parseValue = parseValue;
    }

    private String mockRequestGetting(String uri) throws ReaderException {
        if(uri.equals(workingURI)) {
            return parseValue;
        }
        else
            throw new ReaderException(errorMessage);
    }
}