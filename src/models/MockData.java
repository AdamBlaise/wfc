package models;

import java.util.*;

public class MockData {
    public static List<FitnessClass> TimeTable(){
        List<FitnessClass> fitnessClasses = new ArrayList<FitnessClass>();
        fitnessClasses.add(new FitnessClass(1, LessonTypes().get(0), FitDay.Saturday, 1, 0));
        fitnessClasses.add(new FitnessClass(2, LessonTypes().get(1), FitDay.Saturday, 1, 0));
        fitnessClasses.add(new FitnessClass(3, LessonTypes().get(2), FitDay.Sunday, 1, 0));
        fitnessClasses.add(new FitnessClass(4, LessonTypes().get(3), FitDay.Sunday, 1, 0));
        fitnessClasses.add(new FitnessClass(5, LessonTypes().get(4), FitDay.Saturday, 1, 0));
        return  fitnessClasses;
    }

    public static List<LessonType> LessonTypes(){
        List<LessonType> lessonTypes = new ArrayList<LessonType>();
        lessonTypes.add(new LessonType(20, "Spin"));
        lessonTypes.add(new LessonType(10, "Yoga"));
        lessonTypes.add(new LessonType(15, "BoxFit"));
        lessonTypes.add(new LessonType(25, "Bodysculpt"));
        lessonTypes.add(new LessonType(15, "Zumba"));
        lessonTypes.add(new LessonType(22, "Aquacise"));
        lessonTypes.add(new LessonType(35, "Pilates"));
        lessonTypes.add(new LessonType(10, "Burn"));
        return lessonTypes;
    }

    public static List<Customer> Customers(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Chisom Nwike", 1, "07765642937", "oge.nwike@gmail.com" ));
        customers.add(new Customer("Adam Ayide", 2, "07765642957", "adam.ayide@gmail.com" ));
        return customers;
    }
}
