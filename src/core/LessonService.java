package core;


import DTOs.LessonResponse;
import models.CustomerLessons;
import models.FitnessClass;
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
    }

    public static void GetTimeTableByDay(String fitday){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable().stream().filter(tt -> tt.FitDay == fitday);
        Iterator<FitnessClass> i = lessons.iterator();
        while(i.hasNext()){
            FitnessClass lesson = i.next();
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        };
    }

    public static void GetTimeTableByLessonType(){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable();
        Iterator<FitnessClass> i = lessons.iterator();
        while(i.hasNext()){
            FitnessClass lesson = i.next();
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        };
    }

    public LessonResponse BookLesson(int id)
    {
        var lesson = MockData.TimeTable().stream().filter(t -> t.Id == id).collect(Collectors.toList());
        if (lesson  == null || lesson.isEmpty()) {

            return new LessonResponse("Invalid id selected", false);
        }
        var bookedspaces = lesson.get(1).BookedSpaces;
        if(bookedspaces == 5){
            return  new LessonResponse("This lesson is already filled up", false);
        }
        lesson.get(1).BookedSpaces = bookedspaces - 1;
        return  new LessonResponse("Lesson booked successfully", true);
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

