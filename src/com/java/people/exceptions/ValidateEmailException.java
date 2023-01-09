package people.exceptions;

public class ValidateEmailException extends Exception {

    public ValidateEmailException(String className, Integer hashCode,boolean preferredLang, String currEmailVal) {
        super(String.format("Class %s with hashCode %d and preferred language of %b has been assigned wrong email value" +
                " which is %s", className,hashCode,preferredLang, currEmailVal));

    }

}
