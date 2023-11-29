public class Student extends User {
    private String course1; 
    private String course2;
    private String course3;
    private String course4;
    private String payment;

    public Student(String username, String studentPassword, String course1, String course2, String course3, String course4, String payment) {
        super(username, studentPassword);
        this.course1 = course1; 
        this.course2 = course2;
        this.course3 = course3; 
        this.course4 = course4; 
        this.payment = payment;
    }

    public String getCourse1() {
        return course1;
        
    }
    public String getCourse2() {
        return course2;
        
    }
    public String getCourse3() {
        return course3;
        
    }
    public String getCourse4() {
        return course4;
        
    }
    public void setCourses(String course1, String course2, String course3, String course4) {
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
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