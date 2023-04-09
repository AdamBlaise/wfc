package core;


import DTOs.LessonResponse;
import models.FitnessClass;
import models.MockData;

import java.util.List;
import java.util.stream.Collectors;

public class LessonService {

    public void GetTimeTable(){
        System.out.println("Id \t Week \t Day \t Activity \t Price \t Available Spaces");
        List<FitnessClass> lessons = MockData.TimeTable();
        for (FitnessClass lesson:
             lessons) {
            int availableSpaces = 5 - lesson.BookedSpaces;
            System.out.println(lesson.Id + " \t " + lesson.FitWeek + " \t " + lesson.FitDay + " \t " + lesson.Lesson.Name + " \t " + lesson.Lesson.Price + " \t " + availableSpaces );
        }
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

    public List<FitnessClass> GetCustomerLesson(){

    }
}

