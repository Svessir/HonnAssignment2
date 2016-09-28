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


    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String displayName;
    private LocalDate birthDate;
    private List<Video> videos;

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

    public int getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Video> getVideos() {
        return videos;
    }

}