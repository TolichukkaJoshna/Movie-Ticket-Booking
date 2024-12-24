import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Movie{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Movie Ticket Booking");
        System.out.println("1. Register/Login");
        System.out.println("2. Browse Movies");
        System.out.println("3. Exit");
        System.out.println("Choose any one of them");
        int t=sc.nextInt();
        User  user=new User();
        switch(t){
            case 1:
                boolean a=user.login();
                if(a){
                    System.out.println("\nLogin Successful!\n");
                }
                else{
                    System.out.println("Login Unsucccessfull! Invalid Code Entered Please Verify your Code");
                    return;
                }
                break;
            case 2:
                user.movies();
                return;
            case 3:
                return;
            default:
                System.out.println("Invalid Choose");
                break;
        }
        String[] location={"Ongole","Hyderabad","Mumbai","Bangalore"};
        String[] theatres={"Prasads IMAX","Ratnamahal","Gorantla","Krishna"};
        System.out.println("The available Locations are: ");
        for(int i=0;i<location.length;i++){
            System.out.println((i+1)+". "+location[i]);
        }
        System.out.println("Select the location: ");
        int loc=sc.nextInt();
        int th=0;
        boolean ch=false;
        while(ch==false){
            if(loc>0 && loc<5){
                System.out.println("\nThe Movie theatres available at "+location[loc-1]+" are: ");
                for(int i=0;i<theatres.length;i++){
                    System.out.println((i+1)+". "+theatres[i]);
                }
                System.out.println("Select the theatre you want to book tickets in: ");
                th=sc.nextInt();
                ch=true;
            }
            else{
                System.out.println("Invalid Choose Try Agin:");
                loc=sc.nextInt();
            }
    }
        System.out.println("\nAvailable Movies:");
        String[] mov=user.movies();
        System.out.println("\nSelect the Movie you want to Book:");
        int m=sc.nextInt();
        boolean b=false;
        String times[]={"9:00 am","12:00 pm","3:00 pm","9:00 pm"};
        int time=0;
        while(b==false){
        if(m>0 && m<6){
            b=true;
            System.out.println("\nThe timing for "+mov[m-1]+":");
            for(int i=0;i<times.length;i++){
                System.out.println((i+1)+". "+times[i]);
            }
            System.out.println("\nselect the time you want to book:");
            time=sc.nextInt();
            boolean c=false;
            while(c==false){
                if(time>0 && time<5){
                    c=true;
                    System.out.println("\nSelected time : "+times[time-1]);
                }
                else{
                    System.out.println("invalid choice try again:");
                    time=sc.nextInt();
                }
            }
            System.out.println("\nAvalable Seats : 200");
            String[] cat={"Balcony","Middle","Lower"};
            String[] catp={"$250","$150","$100"};
            System.out.println("The available categories");
            for(int i=0;i<cat.length;i++){
                System.out.println((i+1)+". "+cat[i]+" ("+catp[i]+")");
            }
            System.out.println("Enter the Type of seat you want to Book: ");
            int typeofseat=sc.nextInt();
            if(typeofseat<0 && typeofseat>3){
                System.out.println("Invalid choice");
                return;
            }
            System.out.println("\nEnter the no.of Seats you want to Book:");
            int seats=sc.nextInt();
            int total=0;
            if(seats>0 && seats<=200){
                if(typeofseat==1){
                    total=seats*250;
                }
                else if(typeofseat==2){
                    total=seats*150;
                }
                else{
                    total=seats*100;
                }
                System.out.println("\nTotal cost of "+seats+" seats is : $"+total);
                System.out.println("Platform Charges are: $5");
                System.out.println("Your total Payment is "+(total+5));
                System.out.println("\nDo you want to proceed(yes/no): ");
                sc.nextLine();
                String str=sc.nextLine();
                if(str.equals("yes") || str.equals("Yes") || str.equals("YES")){
                     user.payment(total+5);
                }
                else{
                    return;
                }
            }
            else{
                System.out.println("Sorry "+seats+" seats not avalable.");
                System.out.println("You can book only upto 200 seats: ");
                m=sc.nextInt();
            }
        }
        else{
            System.out.println("invalid chocie Try Again :");
            m=sc.nextInt();
        }
    }
    System.out.println("\nCongratulations Your Booking is Conformed!\n\n");
    System.out.println("Your Booking Details are:");
    System.out.println("Location: "+location[loc-1]);
    System.out.println("Theatre Name: "+theatres[th-1]);
    System.out.println("Movie Name: "+mov[m-1]);
    System.out.println("Movie Timings: "+times[time-1]);
    user.time();
    System.out.println("1. Logout");
    int c=sc.nextInt();
    boolean l=false;
    while(l==false){
    if(c==1){
        l=true;
        System.out.println("\nThanks for the Booking!");
        System.out.println("Hope you will enjoy the show!\n");
    }
    else{
        System.out.println("Please Enter 1 to Logout");
        c=sc.nextInt();
    }
    }
}
}

class User{
    static String name;
    static String email;
    static String password;
    static int uc;
   public boolean login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Your Name : ");
        name=sc.nextLine();
        formatter();
        System.out.println("Enter Your Email :");
        User.email=sc.nextLine();
        System.out.println("Enter Your Mail ID Password :");
        User.password=sc.nextLine();
        System.out.println("Enter the below provided OTP :");
        int rc=random();
        System.out.println(rc);
        User.uc=sc.nextInt();
        if(rc==uc){
            return true;
        }
        return false;    
   }
   public int random(){
    Random ran=new Random();
    int rc=ran.nextInt(10000);
    return rc;
   }
   public void formatter(){
        Formatter f=new Formatter();
        f.format("\nWelcome, %s!\n",User.name);
        System.out.println(f);
        f.close();
   }
   public String[] movies(){
        String mov[]={"The Conjuring","Insidious","Evil Dead","A Quiet Place","The Death Door"};
        for(int i=0;i<mov.length;i++){
            System.out.println((i+1)+". "+mov[i]);
        }
        return mov;
   }
   public void payment(int price){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Payment Mode");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        int pay=sc.nextInt();
        if(pay==1){
            System.out.println("\nEnter Credit Card details:");
            System.out.println("Enter credit card number: ");
            int acc=sc.nextInt();
            System.out.println("Enter your credit pin :");
            int pin=sc.nextInt();
            System.out.println("Enter "+price+" rupees: ");
            int amo=sc.nextInt();
            boolean a=false;
            while(a==false){
                if(price==amo){
                    a=true;
                    System.out.println("\nPayment Successful!\n");
                }
                else{
                    System.out.println("\nInvalid amount entered please Enter correct amount :");
                    amo=sc.nextInt();
                }
            }
        }
        else if(pay==2){
            System.out.println("Enter your UPI pin:");
            int pin=sc.nextInt();
            System.out.println("\nEnter "+price+" rupees: ");
            int amo=sc.nextInt();
            boolean a=false;
            while(a==false){
                if(price==amo){
                    a=true;
                    System.out.println("\nPayment Successful!\n");
                }
                else{
                    System.out.println("\nInvalid amount entered please Enter correct amount :");
                    amo=sc.nextInt();
                }
            }
        }
    }
        public void time(){
            LocalDateTime currentDateTime=LocalDateTime.now();
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss\n");
            String formattedDate=currentDateTime.format(formatter);
            System.out.println(formattedDate);
        }  
}