package people.abstracts;

import java.time.LocalDate;

public abstract class Worker extends Person {
    private float wage;

    public Worker(String name, String surname, LocalDate birthDay, float wage) {
        super(name, surname, birthDay);
        this.wage = wage;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "wage=" + wage +
                "} " + super.toString();
    }
}
