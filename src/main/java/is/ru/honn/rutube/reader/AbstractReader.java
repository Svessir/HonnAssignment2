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

import java.util.Collection;

/**
 * Supertype for a RuTube reader
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public abstract class AbstractReader implements Reader {

    protected ReadHandler readHandler;
    protected String URI;

    /**
     * Reads data from resource and parses it.
     * If a read handler has been set then it is
     * invoked with the parsed data.
     * If the parsed data is a collection then
     * the items within that collection are sent
     * to the read handler else the object itself.
     *
     * @return The parsed from the resource
     */
    @Override
    public Object read() {
        ClientRequest request = new ClientRequest();
        String unParsedData = request.getRequest(URI);
        Object parsed = parse(unParsedData);
        handleParsedObject(parsed);
        return parsed;
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

    /**
     * Invokes the read handler on the parsed data.
     * If the parsed data is a collection then the
     * items within that collection are sent to the
     * read handler else the object itself.
     * If no read handler has been set then this
     * method does nothing.
     *
     * @param parsed Parsed object by the reader
     */
    protected void handleParsedObject(Object parsed) {

        if(readHandler == null)
            return;

        if(parsed instanceof Collection) {
            Collection<Object> collection = ((Collection) parsed);

            int i = 0;
            for(Object record : collection) {
                readHandler.read(i, record);
                i++;
            }
        }
        else
            readHandler.read(0, parsed);

    }
}