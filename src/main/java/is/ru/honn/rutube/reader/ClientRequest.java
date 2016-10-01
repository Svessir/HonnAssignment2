/*************************************************************************************************
 *
 * ClientRequest.java - The ClientRequest class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Component that handles retrieving client requests
 *
 * @author Sverrir
 * @version 1.0, 25 sep. 2016
 */
public class ClientRequest
{
    public ClientRequest()
    {
    }

    /**
     *
     * @param url The url of the request resource
     * @return The data retrieved from the resource as a String
     */
    public String getRequest(String url) throws ReaderException
    {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request().get();

        // Throw exception if status code is not 2xx
        if(!Integer.toString(response.getStatus()).matches("2.."))
            throw new ReaderException("Could not read resource: " +
                    response.getStatus() + " " + response.getStatusInfo());

        String result = response.readEntity(String.class);
        client.close();

        return result;
    }

    /**
     *
     * @param fileName The name of the file that contains the request data
     * @return The data retrieved from the file as a String
     */
    public String getFileContent(String fileName) throws ReaderException
    {
        StringBuilder content = new StringBuilder();
        try
        {
            java.io.FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                content.append(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            String msg = "Unable to open file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        catch(IOException ex)
        {
            String msg = "Error reading file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        return content.toString();
    }

}