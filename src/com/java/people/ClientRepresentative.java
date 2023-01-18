package people;

import java.time.LocalDate;
import java.util.regex.Pattern;
import people.abstracts.Person;
import people.exceptions.ValidateEmailException;

public class ClientRepresentative extends Person {

  private String email;

  public ClientRepresentative(String name, String surname, LocalDate birthDay, String email)
      throws ValidateEmailException {
    super(name, surname, birthDay);
    this.email = email;
    validateEmailException();
  }

  private void validateEmailException() throws ValidateEmailException {
    ///TODO Add this to config
    boolean isLatin = true;
    if (isLatin) {
      if (!patternMatches(getEmail(), "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
          + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$")) {
        throw new ValidateEmailException(this.getClass().getName(), hashCode(), isLatin,
            String.valueOf(getEmail()));
      }
    } else {
      if (!patternMatches(getEmail(), "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
          + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
        throw new ValidateEmailException(this.getClass().getName(), hashCode(), isLatin,
            String.valueOf(getEmail()));
      }
    }

  }

  private boolean patternMatches(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
        .matcher(emailAddress)
        .matches();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "People.ClientRepresentative{" +
        "email='" + email + '\'' +
        '}';
  }
}
