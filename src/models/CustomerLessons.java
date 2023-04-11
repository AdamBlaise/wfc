package models;

public class CustomerLessons {
    public int LessonId;
    public int CustomerId;
    public Boolean Attended;

    public CustomerLessons(int lessonId, int customerId, Boolean attended)
    {
        this.LessonId = lessonId;
        this.CustomerId = customerId;
        this.Attended = attended;
    }
}
