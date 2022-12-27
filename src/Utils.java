public final class Utils {

  public static final boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Integer d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
