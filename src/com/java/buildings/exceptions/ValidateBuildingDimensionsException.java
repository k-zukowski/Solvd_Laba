package buildings.exceptions;

public class ValidateBuildingDimensionsException extends Exception {

  public ValidateBuildingDimensionsException(String className, Integer hashCode, float length,
      float width, float height) {
    super(String.format("Class %s with hashCode %s has been assigned wrong values" +
            " for its dimensions length = %f, width = %f, height = %f", className, hashCode, length,
        width, height));

  }

}
