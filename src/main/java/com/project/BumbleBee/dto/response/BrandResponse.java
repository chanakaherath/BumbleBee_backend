package com.project.BumbleBee.dto.response;

import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;

public class BrandResponse {

    private String id;

    private String name;

    private String description;

    private Status status;

    private Deleted isDeleted;



    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Deleted getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Deleted isDeleted) {
        this.isDeleted = isDeleted;
    }

}
