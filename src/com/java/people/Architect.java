package people;

import java.time.LocalDate;
import people.abstracts.Worker;
import people.enums.Degree;
import utils.MyFileUtils;

public class Architect extends Worker {

  private Degree degree;

  public Architect(String name, String surname, LocalDate birthDay, float wage, Degree degree,
      MyFileUtils myFileUtils) {
    super(name, surname, birthDay, wage);
    this.degree = degree;
    updateWage();
    myFileUtils.myWriteStringToFile(toString(), true);
  }
  public Architect(String name, String surname, LocalDate birthDay, float wage, Degree degree) {
    super(name, surname, birthDay, wage);
    this.degree = degree;
    updateWage();
    //myFileUtils.myWriteStringToFile(toString(), true);
  }

  public Architect() {
  }

  private void updateWage() {
    float currentWage = this.getWage();
    this.setWage(currentWage * degree.getType());
  }

  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  @Override
  public String toString() {
    return "Architect{" +
        "degree=" + degree +
        "} " + super.toString();
  }
}
