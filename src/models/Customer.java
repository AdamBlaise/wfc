package models;

public class Customer {
    public String Name;
    public int Id;
    public String Phone;
    public String Email;

    Customer(String name, int id, String phone, String email)
    {
        this.Name = name;
        this.Id = id;
        this.Phone = phone;
        this.Email = email;
    }
}
