package models;

import java.util.List;

public class CustomerLessons {
    public int Id;
    public int LessonId;
    public int CustomerId;
    public AttendanceStatus Status;

    public CustomerLessons(int id, int lessonId, int customerId, AttendanceStatus status)
    {
        this.Id = id;
        this.LessonId = lessonId;
        this.CustomerId = customerId;
        this.Status = status;
    }
}
