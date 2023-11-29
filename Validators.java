public class Validators {

  static boolean isAlreadySelected(
    String[] selectedCourses,
    String courseCode
  ) {
    for (String selected : selectedCourses) {
      if (courseCode.equals(selected)) {
        return true;
      }
    }
    return false;
  }

  static boolean isValidCourseCode(String code, String[] availableCourses) {
    for (String course : availableCourses) {
      if (course.equals(code)) {
        return true;
      }
    }
    return false;
  }

  public static void validatePassword(String password) {
    if (password == null || password.isEmpty()) {
      throw new IllegalArgumentException("Password cannot be null or empty.");
    }

    if (password.length() < 8 || password.length() > 128) {
      throw new IllegalArgumentException(
        "Password must be at least 8 characters long."
      );
    }
  }
}
