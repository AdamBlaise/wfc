import core.CustomerService;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import static core.BookingService.*;
import static core.CustomerService.GetCustomerByEmail;
import static core.CustomerService.GetCustomers;
import static core.LessonService.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Fit Weekends!");
        Scanner s = new Scanner(System.in);
        int ch;
        ShowMenu(true);

        List<CustomerLessons> customerLessonsList = new ArrayList<>();
        List<LessonReview> lessonReviews = new ArrayList<>();
        List<LessonRate> lessonRates = new ArrayList<>();

        do{
            ch = s.nextInt();
        switch(ch){
            case 0:
                System.exit(0);
                break;
            case 1:
                GetTimeTable();
                break;
            case 2:
                s.nextLine();
                System.out.printf("Enter day in full: ");
                String day = s.nextLine();
                GetTimeTableByDay(day);
                break;
            case 3:
                GetFitnessTypes();
                break;
            case 4:
                s.nextLine();
                System.out.printf("Enter fitness type in full: ");
                String fitnessType = s.nextLine();
                GetTimeTableByLessonType(fitnessType);
                break;
            case 5:
                s.nextLine();
                System.out.printf("Enter customer email: ");
                String customerEmail = s.nextLine();
                System.out.println("Select Class from table below: ");
                GetTimeTable();
                System.out.printf("Enter Id of preferred class: ");
                int preferredClass = s.nextInt();
                s.nextLine();
                var bookLesson = BookLesson(customerLessonsList, preferredClass, customerEmail);
                if (bookLesson.Successful) {
                    var size = customerLessonsList.size();
                    System.out.println(customerLessonsList.get(size -1).CustomerId + "Lesson Booked Successfully...");
                    System.out.println(customerLessonsList);
                    System.out.print("99: Go back to main menu: ");
                }
                else{
                    System.out.println("------------An Error Occurred--------------\n");
                    System.out.println(bookLesson.Message + "\n");
                    System.out.println("------------End of Error Message--------------");
                }
                break;
            case 6:
                System.out.println("Customer Name  \t\t  Lesson Name  \t\t  Lesson Day  \t\t  Lesson Week  \t\t  Lesson Price");
                for(int i = 0; i < customerLessonsList.size(); i++) {
                    var cl = customerLessonsList.get(i);
                    var customer = MockData.Customers().stream().filter(c -> c.Id == cl.CustomerId).collect(Collectors.toList()).get(0);
                    var lesson = MockData.TimeTable().stream().filter(l -> l.Id == cl.LessonId).collect(Collectors.toList()).get(0);
                    System.out.println(customer.Name + "  \t\t  " + lesson.Lesson.Name + "  \t\t\t  " + lesson.FitDay + "  \t\t\t  " + lesson.FitWeek + "  \t\t\t  " + lesson.Lesson.Price);
                }
                System.out.print("99: Go back to main menu: ");
                break;
            case 7:
            case 8:
                GetCustomers();
                s.nextLine();
                System.out.print("Enter Email of customer whose booking you'd like to cancel:  ");
                var email = s.nextLine();
                GetCustomerBookings(customerLessonsList, email, false);
                System.out.print("Enter Lesson Id you'd like to cancel: ");
                int lesId = s.nextInt();
                CancelBooking(customerLessonsList, lesId);
                System.out.print("99: Go back to main menu: ");
                break;
            case 9:
                s.nextLine();
                System.out.print("Enter Customer Email: ");
                var em = s.nextLine();
                var customerId = GetCustomerByEmail(em).Id;
                GetCustomerBookings(customerLessonsList, em, false);
                System.out.print("Select Lesson Id to review: ");
                var lessonToReview = s.nextInt();
                s.nextLine();
                var les = GetLessonById(lessonToReview).Id;
                var reviewMessage = s.nextLine();
                AddReviewForLesson(lessonReviews, les, customerId, reviewMessage);
                System.out.print("Review Added Successfully");
                System.out.print("Would you like to rate the lesson? (y/n)");
                if(s.nextLine() == "y"){
                    System.out.println(java.util.Arrays.asList(RateLevel.values()));
                    System.out.println("Enter rate in full: ");
                    var rate = s.nextLine();
                    RateLesson(lessonRates, les, customerId, rate.toUpperCase());
                }
                break;
            case 10:
                s.nextLine();
                System.out.print("Enter Customer Email: ");
                var customersEmail = s.nextLine();
                var customersId = GetCustomerByEmail(customersEmail).Id;
                GetCustomerBookings(customerLessonsList, customersEmail, false);
                System.out.print("Select Lesson Id to review: ");
                var lessonToRate = s.nextInt();
                s.nextLine();

                System.out.println(java.util.Arrays.asList(RateLevel.values()));
                System.out.println("Enter rate in full: ");
                var rate = s.nextLine();
                RateLesson(lessonRates, lessonToRate, customersId, rate.toUpperCase());
                System.out.print("Rating Added Successfully");
                System.out.print("Would you like to review the lesson? (y/n)");
                if(s.nextLine() == "y")
                {
                    var message = s.nextLine();
                    AddReviewForLesson(lessonReviews, lessonToRate, customersId, message);
                }
                break;
            case 14:
                GetCustomers();
                break;
            case 99:
                ShowMenu(true);
            default:
                System.out.printf("You have to select a number in the menu: _");
                break;
        }
        }while(ch != 0);
    }

    public static void ShowMenu(Boolean isMain)
    {
        System.out.println("1. \tView TimeTable");
        System.out.println("2. \tView TimeTable By Day");
        System.out.println("3. \tView Fitness Types");
        System.out.println("4. \tView TimeTable By Fitness Type");
        System.out.println("5. \tBook A Class");
        System.out.println("6. \tView All Bookings");
        System.out.println("7. \tCancel Booking");
        System.out.println("8. \tChange Booking");
        System.out.println("9. \tWrite a Review for class");
        System.out.println("10.\tRate a class");
        System.out.println("11.\tView Lesson Report and Rating");
        System.out.println("12.\tView Income Report");
        System.out.println("13.\tView Champion Fitness Type");
        System.out.println("14. \tView Customers");
        if(!isMain)
            System.out.println("99.\tBack to Menu");

        System.out.printf("Enter Menu Selection or type 0 to exit the application: ");
    }
}