package com.company.model;
import java.util.*;


public abstract class FitnessCenterClass {
    long id;
    long startTime;
    long endTime;
    long capacity;
    ClassType classType;
    List<User> confirmedUsers=new LinkedList<>();
    List<User> waitingUsers=new LinkedList<>();

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public List<User> getConfirmedUsers() {
        return confirmedUsers;
    }

    public void setConfirmedUsers(List<User> confirmedUsers) {
        this.confirmedUsers = confirmedUsers;
    }

    public List<User> getWaitingUsers() {
        return waitingUsers;
    }

    public void setWaitingUsers(List<User> waitingUsers) {
        this.waitingUsers = waitingUsers;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
