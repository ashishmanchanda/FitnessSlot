package com.company.model;

public class User {
   long id;
   String name;
   long danceClassId;
   long gymClassId;
   long yogaClassId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDanceClassId() {
        return danceClassId;
    }

    public void setDanceClassId(long danceClassId) {
        this.danceClassId = danceClassId;
    }

    public long getGymClassId() {
        return gymClassId;
    }

    public void setGymClassId(long gymClassId) {
        this.gymClassId = gymClassId;
    }

    public long getYogaClassId() {
        return yogaClassId;
    }

    public void setYogaClassId(long yogaClassId) {
        this.yogaClassId = yogaClassId;
    }
}
