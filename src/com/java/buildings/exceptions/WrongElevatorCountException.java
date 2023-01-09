package buildings.exceptions;

public class WrongElevatorCountException extends Exception {
    public WrongElevatorCountException(String className, Integer hashCode, Integer currVal) {
        super(String.format("Class %s with hashCode %d has been assigned wrong elevatorCount value" +
                " which is %d, but should be positive", className,hashCode,currVal));
    }
}
