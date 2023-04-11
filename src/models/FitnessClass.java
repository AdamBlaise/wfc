package models;

import java.util.List;

public class FitnessClass {
    public int Id;
    public FitDay FitDay;
    public LessonType Lesson;
    public int FitWeek;
    public int BookedSpaces;

    public FitnessClass(int id, LessonType lessonType, models.FitDay fitDay, int fitWeek, int bookedSpaces) {
        this.FitWeek = fitWeek;
        this.FitDay = fitDay;
        this.Lesson = lessonType;
        this.BookedSpaces = bookedSpaces;
        this.Id = id;
    }
}


