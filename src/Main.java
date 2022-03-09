import com.sun.javaws.jnl.RContentDesc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static String User;
public static int Password;
    public static void main(String[] args) {
        Scanner scanner_String=new Scanner(System.in);
        Scanner scanner_int=new Scanner(System.in);
        System.out.println("------------Welcome to the application--------------");
        System.out.println("----------------------------------------------------");

            System.out.println("Please enter your user and your pass(national id) lovely Seller");
            try {
                 User=scanner_String.nextLine();
                 Password=scanner_String.nextInt();
                Person person =new Seller(User,Password);
                Seller seller=new Seller();
                seller.Save(User,Password);
                scanner_String.nextLine();
            }
catch (InputMismatchException im)
{
    System.out.println("please enter the right input");
}


try {
    while (true) {

        System.out.println("welcome "+User+"  Please choose the operation"+"\n"+"1-inserting new customer"+"\n"+"2-inserting new product"+"\n"+"3-inserting new bills"+"\n"+"4-removing a customer"+"\n"+"5-removing a product"+"\n"+"6-removing bill");
    int num = scanner_int.nextInt();



    if (num == 1) {
        try {
            boolean g = true;
            System.out.println("please enter the name");
            String Customer_name = scanner_String.nextLine();
            System.out.println("please enter the National Id");
            int National_id = scanner_int.nextInt();
            System.out.println("please enter the Phone");
            int Phone = scanner_int.nextInt();
            System.out.println("please enter the address");
            String address = scanner_String.nextLine();
            Customer customer = new Customer();
            customer.Save(Customer_name, National_id, Phone, address, g);
        }
catch (InputMismatchException im)
{
    System.out.println("please enter the right input dear user");
    System.exit(0);
}
    } else if (num == 2) {
        try
        {
            boolean f = true;
            System.out.println("please enter the Product name");
            String Product_name = scanner_String.nextLine();
            System.out.println("please enter the Company name");
            String Company_name = scanner_String.nextLine();
            System.out.println("please enter the Model");
            String Model = scanner_String.nextLine();
            Product product = new Product();
            product.Save(Product_name, Company_name, Model, f);
        }
        catch (IndexOutOfBoundsException im)

        {
            System.out.println("please enter the right input dear user");

        }

    } else if (num == 3) {
        try
        {
            boolean f = false;
            boolean g = false;
            System.out.println("for creating a bill list you should enter the name of the customer and the name of the product and the amount of the product");
            //---------------------------------------------------------------
            System.out.println("please enter the name of the customer :");
            String Customer_name = scanner_String.nextLine();
            System.out.println("please enter the national id of the customer :");
            int national_id = scanner_int.nextInt();
            System.out.println("please enter the phone of the customer :");
            int Phone = scanner_int.nextInt();
            System.out.println("please enter the address of the customer :");
            String address = scanner_String.nextLine();
            //-------------------------------------------------------------
            System.out.println("please enter the name of the product :");
            String Product_name = scanner_String.nextLine();
            System.out.println("please enter the company of the product :");
            String Company_name = scanner_String.nextLine();
            System.out.println("please enter the model of the product :");
            String Model_name = scanner_String.nextLine();
            //------------------------------------------------------------
            System.out.println("please enter the amount of that product:");
            int the_amount = scanner_int.nextInt();
            //------------------------------------------------------------
            File_Bill file_bill = new File_Bill();
            Person person1 = new Person(Customer_name, national_id);
            Customer customer = new Customer(Customer_name, national_id, Phone, address);
            customer.Save(Customer_name, national_id, Phone, address,f);
            Product product = new Product(Product_name, Company_name, Model_name);
            product.Save(Product_name,Company_name,Model_name,g);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            Bill bill = new Bill(person1, customer, product, timeStamp, the_amount);
        }
catch (InputMismatchException im)
{
    System.out.println("please enter the right input dear user");
}


    } else if (num == 4) {
        try
        {
            System.out.println("Please enter the nation id of the customer: ");
            int National_id = scanner_int.nextInt();
            Customer customer = new Customer();
            customer.Remove(National_id);
        }
        catch (InputMismatchException im)
        {
            System.out.println("please enter the right input dear user");

        }

    } else if (num == 5) {
        try
        {
            System.out.println("Please enter the model of the product: ");
            String model = scanner_String.nextLine();
            Product product = new Product();
            product.Remove(model);
        }
        catch (InputMismatchException im)
        {
            System.out.println("please enter the right input dear user");

        }


    } else if (num == 6) {
        try
        {
            System.out.println("please enter the national id of the customer ");
            int nationalid = scanner_int.nextInt();
            System.out.println("please enter the model of the product");
            String model = scanner_String.nextLine();
            Bill bill=new Bill();
            bill.Remove(nationalid,model);
        }
        catch (InputMismatchException im)
        {
            System.out.println("please enter the right input dear user");

        }


    }
    System.out.println("do you want to continue or end the operation: (pls enter 1 for continuing and 0 for ending): ");
    int starting = scanner_int.nextInt();
    if (starting == 1) {
        continue;
    } else {
        System.out.println("see you soon dear :D");
        break;
    }
}
}
catch (InputMismatchException im)
{
    System.out.println("told u to enter a number not a word -_-");
}

    }
}
