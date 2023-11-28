import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SimpleEnrollmentSystem {
public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        System.out.println("**********************************************************");
        System.out.println(" Welcome to the Online Enrollment System for IT students");
        System.out.println("**********************************************************");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose what method would you do: ");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                Registration();
                break;
            case 2: 
                Login();
                break;
            case 3: 
                break;
            default: System.out.println("Invalid option. Try again!");
        }
      }
    public static void Registration(){
        String studentUsername = "";
        String studentPassword = "";
        String teacherUsername = "";
        String teacherPassword = "";
         System.out.println("Are you a Teacher or a Student?");
         System.out.println("1. Student");
         System.out.println("2. Teacher");
         System.out.print("Enter choice here: ");
         int op2 = scanner.nextInt();
         switch (op2){
            case 1:
                System.out.print("Enter name: ");
                studentUsername = scanner.next();
                System.out.print("Enter password: ");
                studentPassword = scanner.next();
    
                System.out.println("****************************************************************");
                System.out.println("                    IT Available Courses");
                System.out.println("****************************************************************");
                System.out.println("                 COURSES                 |   DAYS  |                TIME                 |  ROOM  |");
                System.out.println("| IT0017 - Discrete Mathematics          |   M/TH  | 13:00:00-15:40:00/13:00:00-15:40:00 |  F505  |");
                System.out.println("| IT0119 - Information Management        |   T/F   | 09:00:00-10:50:00/09:00:00-10:50:00 | ONLINE |");
                System.out.println("| CCS0023 - Object Oriented Programming  |   M/TH  | 10:00:00-11:50:00/10:00:00-11:50:00 | F1202  |");
                System.out.println("| GED0021 - Specialized English 2        |   W/S   |  07:00:00-8:50:00/07:00:00-8:50:00  |  F504  |");
                System.out.println("| IT0019 - Quantitative Methods          |   T/F   | 13:00:00-14:50:00/13:00:00-14:50:00 | ONLINE |");
                System.out.println("| IT0051 - Human COmputer Interaction 2  |   M/TH  |  07:00:00-8:50:00/07:00:00-8:50:00  |  E909  |");
                String[] selectedCourses = new String[4]; // Create an array to store selected courses

                for (int i = 0; i < 4; i++) {
                    System.out.print("Enter course (allowed is only 4 both min. & max.) " + (i + 1) + ": ");
                    selectedCourses[i] = scanner.next();
                }

                
                System.out.println("***********************************************");
                System.out.println("                 COURSES COST");
                System.out.println("***********************************************");
                System.out.println("  P40,000 (each course is fixated at P10,000)");
                System.out.println("");
                System.out.println("***********************************************");
                System.out.println("                PAYMENT METHOD");
                System.out.println("***********************************************");
                System.out.println("1. Full Payment (10% DIscount)");
                System.out.println("2. Downpayment (10% interest)");
                System.out.print("Select payment method: ");
                int op3 = scanner.nextInt();
                switch(op3){
                case 1:
                    System.out.print("Enter amount: ");
                    int amount = scanner.nextInt();
                    if(amount==40000){
                        System.out.println("Amount Paid: P36,000");
                        System.out.println("Change: P4,000");
                        System.out.println("You Are Now Enrolled");
                    }
                    else if(amount>40000){
                        double change = amount - 36000;
                        System.out.println("Change: "+change);
                    }
                    else{
                        System.out.println("That is invalid. Try Again!");
                        
                    }
                    
                break;
                case 2: 
                    System.out.print("Enter amount: ");
                    int amount2 = scanner.nextInt();
                    double paymentleft= 40000 - amount2 + (40000 * 0.1);
                    System.out.println("Amount Left: "+paymentleft);
                    System.out.println("You Are Now Enrolled");
                    
                break;
                }
                Student student = new Student(studentUsername, studentPassword, selectedCourses, "Price of courses: P40,000");

                break;
            case 2: 
                System.out.print("Enter name: ");
                teacherUsername = scanner.next();
                System.out.print("Enter password: ");
                teacherPassword = scanner.next();   
                String[] c = new String[3]; 
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter 3 credentials of yours as a Teacher" + (i + 1) + ": ");
                    c[i] = scanner.next();
                }
                Teacher teacher = new Teacher(teacherUsername,teacherPassword, c);
                break;
                
            default: System.out.println("Invalid option. Try again!");
            try {
            FileWriter writer = new FileWriter("users.txt", true);
            if (op2 == 1) { // Student
                writer.write("Student," + studentUsername + "," + studentPassword + "\n");
            } else if (op2 == 2) { // Teacher
                writer.write("Teacher," + teacherUsername + "," + teacherPassword + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
        }

    public static void Login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        try {
            File file = new File("users.txt");
            Scanner fileReader = new Scanner(file);
            boolean found = false;
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] userDetails = data.split(",");
                if (userDetails[1].equals(username) && userDetails[2].equals(password)) {
                    found = true;
                    System.out.println("Login successful as " + userDetails[0]);
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid username or password.");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
    }

  

