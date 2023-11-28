public class Teacher extends User {
    private String[] credentials;

    public Teacher(String us, String pw, String[] credentials) {
        super(us, pw);
        this.credentials = credentials;
    }

    @Override
    public String getUserType() {
        return "Teacher";
    }
}
/* 
 * be concise and clear when naming variables
 */
