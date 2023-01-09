package people.abstracts;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate birthDay;

    public Person(String name, String surname, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int age() {
        return LocalDate.now().getYear() - this.birthDay.getYear();
    }

    @Override
    public String toString() {
        return "People.Pearson{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
