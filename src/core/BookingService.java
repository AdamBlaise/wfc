package core;

import DTOs.LessonResponse;
import models.CustomerLessons;
import models.MockData;

import java.util.List;
import java.util.stream.Collectors;

public class BookingService {

    public static LessonResponse BookLesson(List<CustomerLessons> customerLessons, int lessonId, String customerEmail)
    {
        var lesson = MockData.TimeTable().stream().filter(t -> t.Id == lessonId).collect(Collectors.toList());
        if (lesson  == null || lesson.isEmpty()) {
            return new LessonResponse("Invalid id selected", false);
        }
        var customer = MockData.Customers().stream().filter(c -> c.Email.equalsIgnoreCase(customerEmail)).collect(Collectors.toList()).get(0);
        if(customer == null)
            return new LessonResponse("Invalid customer Email: false", false);
        var bookedSpaces = lesson.get(0).BookedSpaces;
        if(bookedSpaces == 5){
            return  new LessonResponse("This lesson is already filled up", false);
        }
        bookedSpaces = bookedSpaces + 1;
        customerLessons.add(new CustomerLessons(lessonId, customer.Id, false));
        return  new LessonResponse("Lesson booked successfully", true);
    }
}
