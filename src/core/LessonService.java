package core;

import models.*;

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
        while(i.hasNext())
        {
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

    public static FitnessClass GetLessonById(int id)
    {
        var fitnessClass = MockData.TimeTable().stream().filter(l -> l.Id == id).findFirst().get();
        return  fitnessClass;
    }

    public static void RateLesson(List<LessonRate> lessonRates, int lessonId, int customerId, String rateLevel)
    {
        var rateLev = Enum.valueOf(RateLevel.class, rateLevel);
        lessonRates.add(new LessonRate(lessonId, rateLev, customerId));
    }

    public static void AddReviewForLesson(List<LessonReview> lessonReviews, int lessonId, int customerId, String review)
    {
        lessonReviews.add(new LessonReview(review, lessonId, customerId));
    }
}

