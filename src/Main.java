import models.FitnessClass;
import models.MockData;

import java.util.Iterator;
import java.util.Scanner;

import static core.LessonService.GetTimeTable;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Fit Weekends!");
        Scanner s = new Scanner(System.in);
        int ch;
        do{
            ShowMenu();

            //System.out.println("99.\tBack to Menu");
            System.out.printf("Enter Menu Selection or type 0 to exit the application: ");

            ch = s.nextInt();

            switch(ch){
                case 1:
                    GetTimeTable();
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    break;
                default:
                    System.out.printf("You have to select a number in the menu: _");
                    break;

            }
        }while(ch != 0);
    }

    public static void ShowMenu()
    {
        System.out.println("1. \tView TimeTable");
        System.out.println("2. \tView TimeTable By Day");
        System.out.println("3. \tView Fitness Types");
        System.out.println("4. \tView TimeTable By Fitness Type");
        System.out.println("5. \tBook A Class");
        System.out.println("6. \tView My Bookings");
        System.out.println("7. \tCancel Booking");
        System.out.println("8. \tChange Booking");
        System.out.println("9. \tWrite a Review for class");
        System.out.println("10.\tRate a class");
        System.out.println("11.\tView Lesson Report and Rating");
        System.out.println("12.\tView Income Report");
        System.out.println("13.\tView Champion Fitness Type");
    }
}