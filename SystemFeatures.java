import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class SystemFeatures {
    static String name, password, idNum;
     
   static Scanner scanner = new Scanner(System.in);
     public static String generateIdNumber() {
        LocalDate year = LocalDate.now();
        int currentYear = year.getYear();
        Random random = new Random();
        StringBuilder IdBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int idNumber = random.nextInt(10);
            IdBuilder.append(idNumber);
        }

        String currentYearString = String.valueOf(currentYear);
        String idNumber = currentYearString + IdBuilder.toString();

        return idNumber;
    }

    public static void Registration() {
        System.out.println("Are you a Teacher or a Student?");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Enter choice here: ");
        int role;
    if (scanner.hasNextInt()) {
        role = scanner.nextInt();
    } else {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.next(); 
        return; 
    }

    if (role != 1 && role != 2) {
        System.out.println("Invalid role. Please enter 1 for Student or 2 for Teacher.");
        return; 
    }
        scanner.nextLine(); 
    do {
        System.out.print("Enter Fullname: ");
        name = scanner.nextLine();
        name = name.toUpperCase();

        System.out.print("Enter password: ");
        password = scanner.nextLine();
            
        try {
            Validators.validatePassword(password);
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid password: " + e.getMessage());
         }
     } while (true);
        
        if (role == 1) { // Student
            System.out.print("Enter average grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); 
            if (grade < 80 || grade > 100) {
                System.out.println("Sorry, your grade does not meet the required standard for enrollment.");
                return;
            }
            System.out.println("**************************************************************");
            System.out.println("                    IT Available Courses");
            System.out.println("**************************************************************");
            System.out.println("                 COURSES                 |   DAYS  |                TIME                 |  ROOM  |");
            System.out.println("| IT0017 - Discrete Mathematics          |   M/TH  | 13:00:00-15:40:00/13:00:00-15:40:00 |  F505  |");
            System.out.println("| IT0119 - Information Management        |   T/F   | 09:00:00-10:50:00/09:00:00-10:50:00 | ONLINE |");
            System.out.println("| CCS0023 - Object Oriented Programming  |   M/TH  | 10:00:00-11:50:00/10:00:00-11:50:00 | F1202  |");
            System.out.println("| GED0021 - Specialized English 2        |   W/S   |  07:00:00-8:50:00/07:00:00-8:50:00  |  F504  |");
            System.out.println("| IT0019 - Quantitative Methods          |   T/F   | 13:00:00-14:50:00/13:00:00-14:50:00 | ONLINE |");
            System.out.println("| IT0051 - Human Computer Interaction 2  |   M/TH  |  07:00:00-8:50:00/07:00:00-8:50:00  |  E909  |");

            String[] selectedCourses = new String[4];
            for (int i = 0; i < 4; i++) {
                while (true) {
                    System.out.print("Enter only course code (" + (i + 1) + "/4): ");
                    String courseCode = scanner.next();
                    courseCode = courseCode.toUpperCase();
                    if (Validators.isValidCourseCode(courseCode, User.getAvailableCourses())
                            && !Validators.isAlreadySelected(selectedCourses, courseCode)) {
                        selectedCourses[i] = courseCode;

                        break;
                    } else {
                        System.out.println("Invalid course code or already selected. Please try again.");
                    }
                }
            }
            PaymentMethods.handlePayment();
            String idNumber = generateIdNumber();
            saveUserInfo("ENROLLED", name, password,idNumber, selectedCourses);   
        } else if (role == 2) { // Teacher
            System.out.print("Enter 3 credentials: ");
            String c1 = scanner.nextLine();
            String c2 = scanner.nextLine();
            String c3 = scanner.nextLine();
             String idNumber = generateIdNumber();
            saveUserInfo("APPLIED", name, password,idNumber, new String[]{c1, c2, c3});
        } else {
            System.out.println("Invalid option.");
        }
    }

public static void Login() {
   
    do {
        System.out.print("Enter Id number: ");
        idNum = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
                
        try {
            Validators.validatePassword(password);
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    } while (true);
     
    File file = new File("users.txt");
    boolean loginSuccessful = false;

    try (Scanner fileScanner = new Scanner(file)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.contains("Id Number: " + idNum) && line.contains("Password: " + password)) {
                loginSuccessful = true;
                System.out.println("Login successful for " + idNum);
                displayUserDetails(line);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        return;
    }

    if (!loginSuccessful) {
        System.out.println("Login failed. Username or password is incorrect.");
    }
}

private static void displayUserDetails(String userDetails) {
    System.out.println("User Details:");
    String[] details = userDetails.split(",");
    for (String detail : details) {
        if (detail.trim().startsWith("ENROLLMENT STATUS") || detail.trim().startsWith("Name") || detail.trim().startsWith("Password")) {
            System.out.println(detail.trim());
        } else if (Validators.isValidCourseCode(detail.trim(), details)) {
            System.out.println(detail.trim());
        }
    }
    System.out.println("Price of courses: P40000");
}

public static void deleteUser() {
    System.out.print("Enter user ID to delete: ");
    String deleteUser = scanner.nextLine();

    File file = new File("users.txt");
    if (!file.exists()) {
        System.out.println("No users found.");
        return;
    }

    StringBuilder newFileContent = new StringBuilder();
    boolean userFound = false;

    try (Scanner fileScanner = new Scanner(file)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (!line.contains("Id Number: " + deleteUser + ",")) {
                newFileContent.append(line).append("\n");
            } else {
                userFound = true;
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        return;
    }

    if (userFound) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newFileContent.toString());
            System.out.println("User " + deleteUser + " deleted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    } else {
        System.out.println("User not found.");
    }
}

 private static void saveUserInfo(String status, String name, String password,String idNum, String[] details) {
        try {
            File file = new File("users.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            writer.write("ENROLLMENT STATUS: " + status + ", Name: " + name + ", Id Number: " + idNum + ", Password: " + password);
            for (String detail : details) {
                writer.write(", " + detail);
            }
            writer.write("\n");
            writer.close();
            System.out.println("User information saved successfully.");
            System.out.println("ENROLLMENT STATUS: " + status + ", Name: " + name + ", Id Number: " + idNum + ", Password: " + password);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
