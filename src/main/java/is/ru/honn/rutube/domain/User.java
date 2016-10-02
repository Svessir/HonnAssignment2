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

    /**
     *
     * @param userId            The unique id of the user.
     * @param firstName         The first name of the user.
     * @param lastName          The last name of the user.
     * @param email             The email address of the user.
     * @param displayName       The RuTube front end display name of the user.
     * @param birthDate         The date of birth of the user in the format "YYYY-MM-DD".
     */
    public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.birthDate = LocalDate.parse(birthDate);
        videos = new ArrayList<>();

    }

    /**
     *
     * @return The id of the user
     */
    public int getUserId() {
        return userId;
    }


    /**
     *
     * @return The first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return The last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return The email address of this user
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return The RuTube display name of this user
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @return This user's date of birth
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @return List of all videos owned by this user.
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * Adds a video to the list of videos owned by this user.
     *
     * @param videos The video being assigned authorship of this user.
     */
    public void setVideos(List<Video> videos){
        this.videos = videos;
    }

    /**
     * Assigns authorship of this video to user.
     *
     * @param video The video being assigned authorship to
     */
    public void assignVideoToUser(Video video) {
        this.videos.add(video);
    }

    /**
     * Checks if Object o is this user by comparing their IDs.
     *
     * @param o The objects being tested for equality.
     * @return True if object is equal to this user, else false.
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof User))
            return false;
        User u = (User) o;
        return userId != u.userId ? false : true;
    }

    /**
     *
     * @return String containing this user's first name and last name
     */
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

}