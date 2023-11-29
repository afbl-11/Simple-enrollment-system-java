public class Teacher extends User {
    private String credential1;
    private String credential2;
    private String credential3;
    public Teacher(String us, String pw, String credential1, String credential2, String credential3){
        super(us, pw);
        this.credential1 = credential1;
        this.credential2 = credential2;
        this.credential3 = credential3;
    }
    @Override
    public String getUserType(){
        return "Teacher";
    }
}