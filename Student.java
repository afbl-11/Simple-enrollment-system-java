public class Student extends User {

  private String[] courses; // Change courses to an array of strings
  private String payment;

  public Student(
    String username,
    String studentPassword,
    String[] courses,
    String payment
  ) {
    super(username, studentPassword);
    this.courses = courses; // Assign the courses array
    this.payment = payment;
  }

  public String[] getCourses() {
    return courses;
  }

  public void setCourses(String[] courses) {
    this.courses = courses;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  @Override
  public String getUserType() {
    return "Student";
  }
}
