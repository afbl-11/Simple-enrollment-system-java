import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SystemFeatures {
    static Scanner scanner = new Scanner(System.in);

    public static void Registration() {
       
        String studentUsername = "";
        String studentPassword = "";
        String teacherUsername = "";
        String teacherPassword = "";

        System.out.println("Are you a Teacher or a Student?");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Enter choice here: ");
        
        int userType = scanner.nextInt();
        switch (userType) {
            case 1: {
                System.out.print("Enter name: ");
                studentUsername = scanner.next();
                studentUsername = studentUsername.toUpperCase();
                System.out.print("Enter password: ");
                studentPassword = scanner.next();
                validatePassword(teacherPassword);

                availableCourses();

                String[] selectedCourses = new String[4]; // stores selected courses

                for (int i = 0; i < 4; i++) {
                    System.out.print("Enter course (allowed is only 4 both min. & max.) " + (i + 1) + ": ");
                    selectedCourses[i] = scanner.next();
                    selectedCourses[i].toUpperCase();
                }
                courseCost(); // cost of courses will be seen and the total tuition

                int paymentType = scanner.nextInt();

                paymentMethod(paymentType);

                Student student = new Student(studentUsername, studentPassword, selectedCourses,
                        "Price of courses: P40,000"); // para saan to
            }
                break;
            case 2: {// if user is a teacher
                System.out.print("Enter name: ");
                teacherUsername = scanner.next();
                teacherUsername = teacherUsername.toUpperCase();
                System.out.print("Enter password: ");
                teacherPassword = scanner.next();
                validatePassword(teacherPassword);
                String[] credentials = new String[3];

                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter 3 credentials of yours as a Teacher" + (i + 1) + ": "); // what do you mean of credentials
                    credentials[i] = scanner.next();
                }
                Teacher teacher = new Teacher(teacherUsername, teacherPassword, credentials);
                // i guess these constructor will be used to write data in the files?  
            }
                break;

            default: {
                System.out.println("Invalid option. Try again!");
            }
                break;
        }
        try {
            FileWriter writer = new FileWriter("users.txt", true);
                if (userType == 1) { // Student
                writer.write("Student," + studentUsername + "," + studentPassword + "\n");
                } else if (userType == 2) { // Teacher
                writer.write("Teacher," + teacherUsername + "," + teacherPassword + "\n");
                }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
        /* 
         * file couldnt be created because it was inside the switch statement
         */
      
    }
    
    public static void Login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        username = username.toUpperCase();
        System.out.print("Enter password: ");
        String password = scanner.next();
        validatePassword(password);

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
    
    public static void availableCourses() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.println("                                    IT Available Courses");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.println(
                "  CODE           COURSES                 |   DAYS  |                TIME                 |  ROOM  |");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.println(
                "| IT0017 - Discrete Mathematics          |   M/TH  | 13:00:00-15:40:00/13:00:00-15:40:00 |  F505  |");
        System.out.println(
                "| IT0119 - Information Management        |   T/F   | 09:00:00-10:50:00/09:00:00-10:50:00 | ONLINE |");
        System.out.println(
                "| CCS0023 - Object Oriented Programming  |   M/TH  | 10:00:00-11:50:00/10:00:00-11:50:00 | F1202  |");
        System.out.println(
                "| GED0021 - Specialized English 2        |   W/S   |  07:00:00-8:50:00/07:00:00-8:50:00  |  F504  |");
        System.out.println(
                "| IT0019 - Quantitative Methods          |   T/F   | 13:00:00-14:50:00/13:00:00-14:50:00 | ONLINE |");
        System.out.println(
                "| IT0051 - Human COmputer Interaction 2  |   M/TH  |  07:00:00-8:50:00/07:00:00-8:50:00  |  E909  |");
        System.out.println("Enter only the course code: ");
    }

    public static void courseCost() {
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
    }

    public static void paymentMethod(int payment) {
        if (payment == 1) {
            try {
                System.out.print("Enter amount: ");
                int amount = scanner.nextInt();

                if (amount == 40000) {
                    System.out.println("Amount Paid: P36,000");
                    System.out.println("Change: P4,000");
                    System.out.println("You Are Now Enrolled");
                } else if (amount > 40000) {
                    amount -= 36000; // bat to 36k (jurell)
                    System.out.println("Change: " + amount);
                } else {
                    System.out.println("That is invalid. Try Again!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer amount.");
                scanner.nextLine();
            }
        } else if (payment == 2) {
            try {
                System.out.print("Enter amount: ");
                int amount2 = scanner.nextInt();
                double paymentLeft = 40000 - amount2 + (40000 * 0.1);
                System.out.println("Amount Left: " + paymentLeft);
                System.out.println("You Are Now Enrolled");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer amount.");
                scanner.nextLine();
            }
        }

    }
    public static void validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        // Check if the password length is less than the minimum required
        if (password.length() < 8 || password.length() > 128) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }

        // Additional password validation criteria can be added here

        // If the password passes all checks, it is considered valid
    }
}
