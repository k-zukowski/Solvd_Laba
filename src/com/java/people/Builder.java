package people;

import people.abstracts.Worker;
import people.exceptions.WrongYearsOfExperienceException;

import java.time.LocalDate;

public class Builder extends Worker {

    private int yearsOfExperience;

    public Builder(String name, String surname, LocalDate birthDay, float wage, int yearsOfExperience) throws WrongYearsOfExperienceException {
        super(name, surname, birthDay, wage);
        this.yearsOfExperience = yearsOfExperience;
        if (yearsOfExperience < 0) {
            throw new WrongYearsOfExperienceException(this.getClass().getName(), hashCode(), this.yearsOfExperience);
        }
    }

    public final int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public final void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "People.Builder{" +
                "yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
