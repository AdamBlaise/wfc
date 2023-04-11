package DTOs;

public class LessonResponse {
    public Boolean Successful;
    public String Message;

    public LessonResponse(String message, Boolean successful)
    {
        this.Message = message;
        this.Successful = successful;
    }
}
