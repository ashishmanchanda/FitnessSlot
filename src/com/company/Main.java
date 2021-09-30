package com.company;

import com.company.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static FitnessCenter generateData(){
        FitnessCenter fitnessCenter=new FitnessCenter();
        for (int i = 1; i < 10; i++) {
            User u = new User();
            u.setId(i);
            fitnessCenter.getUsers().add(u);
        }

        int counter=7;
        for (int i = 1; i < 4; i++) {
            GymClass gymClass = new GymClass();
            gymClass.setId(i);
            gymClass.setCapacity(3);
            gymClass.setStartTime(counter * i);
            gymClass.setEndTime(counter * i + 1);
            fitnessCenter.getFitnessCenterClasses().add(gymClass);
        }

        counter=5;
        for (int i = 1; i < 4; i++) {
            YogaClass yogaClass = new YogaClass();
            yogaClass.setId(i);
            yogaClass.setCapacity(3);
            yogaClass.setStartTime(counter * i);
            yogaClass.setEndTime(counter * i + 1);
            fitnessCenter.getFitnessCenterClasses().add(yogaClass);
        }

        counter=3;
        for (int i = 1; i < 4; i++) {
            DanceClass danceClass = new DanceClass();
            danceClass.setId(i);
            danceClass.setCapacity(3);
            danceClass.setStartTime(counter * i);
            danceClass.setEndTime(counter * i + 1);
            fitnessCenter.getFitnessCenterClasses().add(danceClass);
        }

        return fitnessCenter;
    }

    public static void main(String[] args) {
        FitnessCenter fitnessCenter=generateData();
        fitnessCenter.getUsers().forEach(u -> {
            System.out.println(fitnessCenter.bookClass(u, ClassType.GYM, 7, 8));
            System.out.println(fitnessCenter.bookClass(u, ClassType.YOGA, 5, 6));
            System.out.println(fitnessCenter.bookClass(u, ClassType.DANCE, 3, 4));
        });

        fitnessCenter.getUsers().forEach(u -> {
            System.out.println(fitnessCenter.cancelClass(u, 6.55, ClassType.GYM));
            System.out.println(fitnessCenter.cancelClass(u, 4.5, ClassType.YOGA));
            System.out.println(fitnessCenter.cancelClass(u, 2.5, ClassType.DANCE));
        });
    }
}
