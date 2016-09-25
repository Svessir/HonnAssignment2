/*************************************************************************************************
 *
 * User.java - The User class.
 *
 * Copyright (c) 2016 Sverrir Magnússon & Kári Eiríksson. 
 * All rights reserved.
 *
 **************************************************************************************************/

package is.ru.honn.rutube.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Object that holds all relevant information
 * about a RuTube user.
 *
 * @author Sverrir
 * @version 1.0, 21 sep. 2016
 */
public class User {


    int userId;
    String firstName;
    String lastName;
    String email;
    String displayName;
    LocalDate birthDate;
    List<Video> videos;

    public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.birthDate = LocalDate.parse(birthDate);
        videos = new ArrayList<>();

    }
    public void setVideos(List<Video> videos){
        this.videos = videos;
    }
}