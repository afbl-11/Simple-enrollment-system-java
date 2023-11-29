public abstract class User {

  private String username;
  private String password;
  private static final String[] availableCourses = {
    "IT0017",
    "IT0051",
    "IT0019",
    "IT0119",
    "CCS0023",
    "GED0021",
  };

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public static String[] getAvailableCourses() {
    return availableCourses;
  }

  public abstract String getUserType();
}
