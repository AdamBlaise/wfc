package core;

import DTOs.LessonResponse;
import models.AttendanceStatus;
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
        lesson.get(0).BookedSpaces+=1;
        var listSize = customerLessons.size();
        var newId = listSize > 0 ? customerLessons.get(listSize -1).Id++ : 1;
        customerLessons.add(new CustomerLessons(newId, lessonId, customer.Id, AttendanceStatus.Booked));
        return  new LessonResponse("Lesson booked successfully", true);
    }

    public static LessonResponse CancelBooking(List<CustomerLessons> customerLessons, int id)
    {
        var bookingToCancel = customerLessons.stream().filter(cl -> cl.Id == id).findFirst().get();
        if(bookingToCancel ==  null)
            return new LessonResponse("Select a valid Lesson: ", false);
        bookingToCancel.Status = AttendanceStatus.Cancelled;
        return new LessonResponse("Lesson cancelled successfully", true);
    }

    public static void GetCustomerBookings(List<CustomerLessons> customerLessons, String email, Boolean showBackMenu)
    {
        var customer = MockData.Customers().stream().filter(c -> c.Email.equalsIgnoreCase(email)).findFirst().get();
        var customerslessons = customerLessons.stream().filter(cl -> cl.CustomerId == customer.Id).collect(Collectors.toList());
        System.out.println("Lesson Id  \t\t  Customer Name  \t\t  Lesson Name  \t\t  Lesson Day  \t\t  Lesson Week  \t\t  Lesson Price");
        for(int i = 0; i < customerslessons.size(); i++) {
            var cl = customerslessons.get(i);
            var lesson = MockData.TimeTable().stream().filter(l -> l.Id == cl.LessonId).collect(Collectors.toList()).get(0);
            System.out.println( lesson.Id + "  \t\t  " +customer.Name + "  \t\t  " + lesson.Lesson.Name + "  \t\t\t  " + lesson.FitDay + "  \t\t\t  " + lesson.FitWeek + "  \t\t\t  " + lesson.Lesson.Price);
        }
        if(showBackMenu)
            System.out.print("99: Go back to main menu: ");
    }
}
