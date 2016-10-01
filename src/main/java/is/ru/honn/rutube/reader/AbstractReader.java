/*************************************************************************************************
 *
 * AbstractReader.java - The AbstractReader class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import org.json.simple.JSONObject;

/**
 * Supertype for a RuTube reader
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public abstract class AbstractReader implements Reader {

    protected ReadHandler readHandler;
    protected String URI;
    protected Request request;

    /**
     * Reads data from resource and parses it.
     *
     * @return The parsed object from the resource
     * @throws ReaderException If readHandler has not been set or if reading fails.
     */
    @Override
    public Object read() throws ReaderException {

        if(readHandler == null)
            throw new ReaderException("Read aborted: readHandler not set.");

        return parse(request.getRequest(URI));
    }

    /**
     * Set the Uniform Resource Identifier for this reader.
     *
     * @param URI The Uniform Resource Identifier
     */
    @Override
    public void setURI(String URI) {
        this.URI = URI;
    }

    /**
     * Set callback handler for the data being read.
     *
     * @param readHandler The object that will handle the
     */
    @Override
    public void setReadHandler(ReadHandler readHandler) {
        this.readHandler = readHandler;
    }

    /**
     * Sets the component that handles request for this reader
     *
     * @param request The component that will handle the requests
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     *
     * @param jParent Json parent containing an integer field.
     * @param name name of the integer field
     * @return int value of the json int in the jParent object.
     */
    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }
}