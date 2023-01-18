package people;

import java.time.LocalDate;
import java.util.ArrayList;
import orders.Project;
import people.abstracts.Worker;
import people.exceptions.WrongYearsOfExperienceException;

public class Builder extends Worker {

  private int yearsOfExperience;
  private ArrayList<Project> projects = new ArrayList<>();

  public Builder(String name, String surname, LocalDate birthDay, float wage, int yearsOfExperience)
      throws WrongYearsOfExperienceException {
    super(name, surname, birthDay, wage);
    this.yearsOfExperience = yearsOfExperience;
    if (yearsOfExperience < 0) {
      throw new WrongYearsOfExperienceException(this.getClass().getName(), hashCode(),
          this.yearsOfExperience);
    }
  }

  public Builder() {
  }

  public ArrayList<Project> getProjects() {
    return projects;
  }

  public void addProject(Project project) {
    this.projects.add(project);
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
