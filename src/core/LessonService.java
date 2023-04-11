package core;


import DTOs.LessonResponse;
import models.CustomerLessons;
import models.FitnessClass;
import models.LessonType;
import models.MockData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LessonService {

    public static void GetTimeTable(){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable();
        Iterator<FitnessClass> i = lessons.iterator();
        while(i.hasNext()){
            FitnessClass lesson = i.next();
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        };

        System.out.println("99.\tBack to Menu");
    }

    public static void GetFitnessTypes(){
        System.out.println("Name \t \t Price");
        List<LessonType> lessonTypes = MockData.LessonTypes();
        Iterator<LessonType> i = lessonTypes.iterator();
        while(i.hasNext()){
            LessonType lessonType = i.next();
            System.out.println(lessonType.Name + " \t \t " + lessonType.Price );
        };

        System.out.println("99.\tBack to Menu");
    }

    public static void GetTimeTableByDay(String fitDay){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable().stream().filter(tt -> tt.FitDay.name().equalsIgnoreCase(fitDay)).collect(Collectors.toList());
        Iterator<FitnessClass> i = lessons.iterator();
        System.out.println("lessons iterator has next: "+ i.hasNext());
        while(i.hasNext()){
            FitnessClass lesson = i.next();
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        };

        System.out.println("99.\tBack to Menu");
    }

    public static void GetTimeTableByLessonType(String fitnessType){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable().stream().filter(tt -> tt.Lesson.Name.equalsIgnoreCase(fitnessType)).collect(Collectors.toList());;
        Iterator<FitnessClass> i = lessons.iterator();
        while(i.hasNext()){
            FitnessClass lesson = i.next();
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        };
    }

    public LessonResponse CancelLesson(int id)
    {
        return new LessonResponse("Lesson cancelled successfully", true);
    }

    public List<CustomerLessons> GetCustomerLesson(){
        List<CustomerLessons> customerLessons = new ArrayList() {{
            add(new CustomerLessons(MockData.TimeTable().get(0).Id, MockData.Customers().get(0).Id, false));
            add(new CustomerLessons(MockData.TimeTable().get(1).Id, MockData.Customers().get(0).Id, false));
        }};

        return customerLessons;
    }
}

