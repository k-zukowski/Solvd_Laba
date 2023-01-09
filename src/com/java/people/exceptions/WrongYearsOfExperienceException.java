package people.exceptions;

public class WrongYearsOfExperienceException extends Exception {
    public WrongYearsOfExperienceException(String className, Integer hashCode, Integer currVal ) {
        super(String.format("Class %s with hashCode %d has been assigned wrong years of experience value" +
                " which is %d, but should be positive", className,hashCode,currVal));

    }
}
