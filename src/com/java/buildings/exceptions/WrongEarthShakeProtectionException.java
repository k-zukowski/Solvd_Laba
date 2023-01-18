package buildings.exceptions;

public class WrongEarthShakeProtectionException extends Exception {

  public WrongEarthShakeProtectionException(String className, Integer hashCode,
      Integer earthShakeProtectionVal) {
    super(String.format(
        "Class %s with hashCode %s has been assigned wrong getEarthShakeProtection value" +
            " which is %d, but should be within 0-10 range", className, hashCode,
        earthShakeProtectionVal));

  }
}
