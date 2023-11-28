public abstract class User {
    private String username;
    private String password;
    
    public User(String us, String pw){
        this.username = username;
        this.password = password;
        
    }
    
     
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public abstract String getUserType();
}