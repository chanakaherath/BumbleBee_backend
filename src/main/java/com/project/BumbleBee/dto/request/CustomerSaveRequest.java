package com.project.BumbleBee.dto.request;

import java.util.Date;

public class CustomerSaveRequest {

    private String firstName;

    private String lastName;

    private String birthday;

    private UserSaveRequest user;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public UserSaveRequest getUser() {
        return user;
    }

    public void setUser(UserSaveRequest user) {
        this.user = user;
    }
}
