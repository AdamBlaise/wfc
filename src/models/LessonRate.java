package models;

public class LessonRate {
    public int LessonId;
    public RateLevel Rating;
    public int CustomerId;

    public LessonRate(int lessonId, RateLevel rating, int customerId)
    {
        this.LessonId = lessonId;
        this.Rating = rating;
        this.CustomerId = customerId;
    }
}
