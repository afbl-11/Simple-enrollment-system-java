import java.util.Scanner;


public class SimpleEnrollmentSystem {
    public static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        while (true) {
        System.out.println("********************************************************");
        System.out.println(" Welcome to the Online Enrollment System for IT students");
        System.out.println("********************************************************");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Delete Users");
        System.out.println("4. Exit");
        System.out.print("Choose what method would you do: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            continue;
        }

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                SystemFeatures.Registration();
                break;
            case 2:
                SystemFeatures.Login();
                break;
            case 3:
                SystemFeatures.deleteUser();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid option. Try again!");
        }
        }
    }
}
        

    
    
  

  

