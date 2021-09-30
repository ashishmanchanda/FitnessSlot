package com.company.model;
import java.util.*;

public class FitnessCenter {
     static List<DanceClass> danceClassList=new LinkedList<>();
     static List<YogaClass> yogaClassList=new LinkedList<>();
     static List<GymClass> gymClassList=new LinkedList<>();
     static List<FitnessCenterClass> fitnessCenterClasses=new LinkedList<>();
     HashMap<ClassType,List<FitnessCenterClass>> classTypeListHashMap=new HashMap<>();
     static List<User> users=new LinkedList<>();
    public List<DanceClass> getDanceClassList() {
        return danceClassList;
    }

    public void setDanceClassList(List<DanceClass> danceClassList) {
        this.danceClassList = danceClassList;
    }

    public List<YogaClass> getYogaClassList() {
        return yogaClassList;
    }

    public void setYogaClassList(List<YogaClass> yogaClassList) {
        this.yogaClassList = yogaClassList;
    }

    public List<GymClass> getGymClassList() {
        return gymClassList;
    }

    public void setGymClassList(List<GymClass> gymClassList) {
        this.gymClassList = gymClassList;
    }

    public  List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        FitnessCenter.users = users;
    }

    public static List<FitnessCenterClass> getFitnessCenterClasses() {
        return fitnessCenterClasses;
    }

    public static void setFitnessCenterClasses(List<FitnessCenterClass> fitnessCenterClasses) {
        FitnessCenter.fitnessCenterClasses = fitnessCenterClasses;
    }

    public String bookGymClass(User user,long starttime,long endtime){
        Optional<GymClass> gymClassOptional = gymClassList.stream().filter(gymClass -> gymClass.startTime == starttime && gymClass.endTime == endtime).findFirst();
        if (gymClassOptional.isPresent()) {
            GymClass gymClass = gymClassOptional.get();
            if (gymClass.getConfirmedUsers().size() < gymClass.capacity) {
                gymClass.getConfirmedUsers().add(user);
                user.setGymClassId(gymClass.getId());
                return "CLASS BOOKED SUCCESSFULLY FOR USER"+user.getId();
            }else {
                gymClass.getWaitingUsers().add(user);
                return "USER ADDED TO THE WAITING LIST";
            }
        }
        return "NO SUCH CLASS FOUND";
    }

     public String bookYogaClass(User user,long starttime,long endtime){
        Optional<YogaClass> yogaClassOptional = yogaClassList.stream().filter(gymClass -> gymClass.startTime == starttime && gymClass.endTime == endtime).findFirst();
        if (yogaClassOptional.isPresent()) {
            YogaClass yogaClass = yogaClassOptional.get();
            if (yogaClass.getConfirmedUsers().size() < yogaClass.capacity) {
                yogaClass.getConfirmedUsers().add(user);
                user.setYogaClassId(yogaClass.getId());
                return "CLASS BOOKED SUCCESSFULLY FOR USER"+user.getId();
            }else {
                yogaClass.getWaitingUsers().add(user);
                return "USER ADDED TO THE WAITING LIST";
            }
        }
         return "NO SUCH CLASS FOUND";
    }

     public String bookDanceClass(User user,long starttime,long endtime){
        Optional<DanceClass> danceClassOptional = danceClassList.stream().filter(gymClass -> gymClass.startTime == starttime && gymClass.endTime == endtime).findFirst();
        if (danceClassOptional.isPresent()) {
            DanceClass danceClass = danceClassOptional.get();
            if (danceClass.getConfirmedUsers().size() < danceClass.capacity) {
                danceClass.getConfirmedUsers().add(user);
                user.setDanceClassId(danceClass.getId());
                return "CLASS BOOKED SUCCESSFULLY FOR USER"+user.getId();
            }else {
                danceClass.getWaitingUsers().add(user);
                return "USER ADDED TO THE WAITING LIST";
            }
        }
         return "NO SUCH CLASS FOUND";
    }

     public String  bookClass(User user, ClassType classType, long starttime, long endtime) {
        /*switch (classType) {
            case GYM:
                return bookGymClass(user, starttime, endtime);
            case YOGA:
               return bookYogaClass(user, starttime, endtime);
            case DANCE:
                return bookDanceClass(user, starttime, endtime);
            default:
                return "NO SUCH CLASS FOUND";

        }*/
         Optional<FitnessCenterClass> fitnessCenterClassOptional= fitnessCenterClasses.stream().filter(fitnessCenterClass -> fitnessCenterClass.startTime == starttime && fitnessCenterClass.endTime == endtime && fitnessCenterClass.classType==classType ).findFirst();
         if (fitnessCenterClassOptional.isPresent()) {
             FitnessCenterClass fitnessCenterClass = fitnessCenterClassOptional.get();
             if (fitnessCenterClass.getConfirmedUsers().size() < fitnessCenterClass.capacity) {
                 fitnessCenterClass.getConfirmedUsers().add(user);
                 user.setDanceClassId(fitnessCenterClass.getId());
                 return "CLASS BOOKED SUCCESSFULLY FOR USER"+user.getId();
             }else {
                 fitnessCenterClass.getWaitingUsers().add(user);
                 return "USER ADDED TO THE WAITING LIST";
             }
         }
         return "NO SUCH CLASS FOUND";

    }

     public String cancelGymClass(User user, double cancelTime) {
        Optional<GymClass> gymClassOptional = gymClassList.stream().filter(gymClass -> gymClass.getId() == user.getGymClassId()).findFirst();
        if (gymClassOptional.isPresent()) {
            GymClass gymClass = gymClassOptional.get();
            double starttimed=(double)gymClass.getStartTime();
           if(starttimed>cancelTime && starttimed- cancelTime >= 0.5) {
               gymClass.getConfirmedUsers().remove(user);
               user.setGymClassId(0);
               if (!gymClass.getWaitingUsers().isEmpty()) {
                   gymClass.getConfirmedUsers().add(gymClass.getWaitingUsers().get(0));
                   return "CLASS CANCELLED SUCCESSFULLY AND WAITING USER CONFIRMED";
               } else {
                   return "CLASS CANCELLED SUCCESSFULLY";
               }
           }else {
               return "CLASS CANNOT BE CANCELLED";
           }
        }
         return "NO SUCH CLASS FOUND";
    }

     public String cancelyogaClass(User user, double cancelTime){
        Optional<YogaClass>  yogaClassOptional = yogaClassList.stream().filter(gymClass -> gymClass.getId() == user.getYogaClassId()).findFirst();
        if (yogaClassOptional.isPresent()) {
            YogaClass yogaClass = yogaClassOptional.get();
            double starttimed=(double)yogaClass.getStartTime();
            if(starttimed>cancelTime && starttimed- cancelTime >= 0.5) {
                yogaClass.getConfirmedUsers().remove(user);
                user.setYogaClassId(0);
                if (!yogaClass.getWaitingUsers().isEmpty()) {
                    yogaClass.getConfirmedUsers().add(yogaClass.getWaitingUsers().stream().findFirst().orElse(null));
                    return "CLASS CANCELLED SUCCESSFULLY AND WAITING USER CONFIRMED";
                } else {
                    return "CLASS CANCELLED SUCCESSFULLY";
                }
            }else {
                return "CLASS CANNOT BE CANCELLED";
            }
        }
         return "NO SUCH CLASS FOUND";
    }

    public String cancelDanceClass(User user, double cancelTime) {
        Optional<DanceClass> danceClassOptional = danceClassList.stream().filter(gymClass -> gymClass.getId() == user.getDanceClassId()).findFirst();
        if (danceClassOptional.isPresent()) {
            DanceClass danceClass = danceClassOptional.get();
            double starttimed = (double) danceClass.getStartTime();
            if (starttimed > cancelTime && starttimed -  cancelTime >= 0.5) {
                danceClass.getConfirmedUsers().remove(user);
                user.setDanceClassId(0);
                if (!danceClass.getWaitingUsers().isEmpty()) {
                    danceClass.getConfirmedUsers().add(danceClass.getWaitingUsers().stream().findFirst().orElse(null));
                    return "CLASS CANCELLED SUCCESSFULLY AND WAITING USER CONFIRMED";
                } else {
                    return "CLASS CANCELLED SUCCESSFULLY";
                }
            } else {
                return "CLASS CANNOT BE CANCELLED";
            }

        }
        return "NO SUCH CLASS FOUND";
    }

    public String cancelClass(User user, double cancelTime, ClassType classType) {
        switch (classType) {
            case GYM:
                return cancelGymClass(user, cancelTime);
            case YOGA:
                return cancelyogaClass(user, cancelTime);
            case DANCE:
                return cancelDanceClass(user, cancelTime);
            default:
                return "NO SUCH CLASS FOUND";
        }
    }

}
