/*************************************************************************************************
 *
 * MockReader.java - The MockReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.mock;

import is.ru.honn.rutube.reader.ReadHandler;
import is.ru.honn.rutube.reader.Reader;

/**
 * Component that mocks a reader
 *
 * @author Sverrir
 * @version 1.0, 02 okt. 2016
 */
public class MockReader implements Reader {

    private Object parseReturnValue;

    @Override
    public Object read() {
        return null;
    }

    @Override
    public Object parse(String content) {
        return parseReturnValue;
    }

    @Override
    public void setURI(String URI) {

    }

    @Override
    public void setReadHandler(ReadHandler readHandler) {

    }

    public void setParseReturnValue(Object parseReturnValue) {
        this.parseReturnValue = parseReturnValue;
    }
}