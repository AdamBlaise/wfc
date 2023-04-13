package core;

import models.Customer;
import models.FitnessClass;
import models.MockData;

import java.util.Iterator;
import java.util.List;

public class CustomerService {

    public static void GetCustomers(){
        System.out.println("Id \t Name \t Email \t Phone");
        List<Customer> customers = MockData.Customers();
        Iterator<Customer> i = customers.iterator();
        while(i.hasNext()){
            Customer customer = i.next();
            System.out.println(customer.Id + " \t " + customer.Name + " \t " + customer.Email + " \t " + customer.Phone);
        };
        System.out.println("99.\tBack to Menu");
    }

    public static Customer GetCustomerById(int id){
        var customer = MockData.Customers().stream().filter(c -> c.Id == id).findFirst().get();
        return customer;
    }

    public static Customer GetCustomerByEmail(String email){
        var customer = MockData.Customers().stream().filter(c -> c.Email == email).findFirst().get();
        return customer;
    }
}
