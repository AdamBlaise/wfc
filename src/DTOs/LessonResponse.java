package DTOs;

public class LessonResponse {
    public String Message;
    public Boolean Success;

    public LessonResponse(String message, Boolean success){
        this.Message = message;
        this.Success = success;
    }
}
