import java.util.Scanner;

public class PaymentMethods {
    static Scanner scanner = new Scanner(System.in);
  
    public static void handlePayment() {
          int method = 0;
        System.out.println("*********************************************");
        System.out.println("                 COURSES COST");
        System.out.println("*********************************************");
        System.out.println("  P40,000 (each course is fixated at P10,000)");

        System.out.println("*********************************************");
        System.out.println("                PAYMENT METHOD");
        System.out.println("*********************************************");
        System.out.println("1. Full Payment (10% Discount)");
        System.out.println("2. Downpayment (10% Interest)");
        do {
            System.out.print("Select payment method: ");
            if (scanner.hasNextInt()) {
                method = scanner.nextInt();
                //scanner.nextLine(); 
                if (method == 1) {
                    processFullPayment();
                    break; 
                } else if (method == 2) {
                    processDownPayment();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                //scanner.nextLine(); 
            }
        } while (method != 1 && method != 2);
            
        
}
   
  private static void processFullPayment() {
    int amount = 0;
    while (amount < 40000) {
        System.out.print("Enter amount: ");
        amount = scanner.nextInt();
        scanner.nextLine();
        if (amount < 40000) {
            System.out.println("That is invalid. Try Again!");
        }
    }

    if (amount == 40000) {
        System.out.println("Amount Paid: " + amount);
        System.out.println("You Are Now Enrolled");
    } else {
        int change = amount - 36000;
        System.out.println("Change: P" + change);
        System.out.println("You Are Now Enrolled");
    }
}


    private static void processDownPayment() {
        System.out.print("Enter downpayment amount: ");
        int amount = scanner.nextInt();
        double remaining = 40000 - amount + (40000 * 0.1);
        scanner.nextLine();
        System.out.println("Amount Left: P" + remaining);
        System.out.println("You Are Now Enrolled");
    }

   
}
