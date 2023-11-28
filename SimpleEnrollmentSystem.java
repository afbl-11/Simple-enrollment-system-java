import java.util.Scanner;

public class SimpleEnrollmentSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* 
         * prob5's:
         * teacher registration bug
         * file should also write the surname
         * better if there is variable firstName, lastName para controlled
         * may nagalaw yata ako sa payment method, may sukli saken kahit fully paid. antok nako pre
         * 
         * fixes:
         * code modularization (made it cleaner, break down some methods, created a new class)
         * password validation
         * file creation
         * 
         * bukas pwede ko pa iintegrate yung paggawa student id. better if meron student id for verification
         * matatanong tayo nyan ni sir about sa security ng program
         * 
         * if ever trabahuin nyo wag nyo na ichat gpt lahat ng code, hanapin nalang asan banda yung prob5 if ever
         * gumawa kayo and then magka error.
         * 
         * so far yun palang.
         */
        
        int option;
        do {
        System.out.println("**********************************************************");
        System.out.println(" Welcome to the Online Enrollment System for IT students");
        System.out.println("**********************************************************");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose what method would you do: ");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                SystemFeatures.Registration();
                break;
            case 2:
                SystemFeatures.Login();
                break;
            case 3://exit
                break;
            default:
                System.out.println("Invalid option. Try again!");
                break;
        }
        } while (option == 3);
       
    }

}

  

