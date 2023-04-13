package models;

public class LessonReview {
    public int LessonId;
    public String Review;
    public int CustomerId;

    public LessonReview(String message, int lessonId, int customerId)
    {
        this.Review = message;
        this.LessonId = lessonId;
        this.CustomerId = customerId;
    }
}
