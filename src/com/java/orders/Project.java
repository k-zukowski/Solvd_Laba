package orders;

import buildings.abstracts.Building;
import buildings.interfaces.IBuildingTypeFunctionality;
import java.util.ArrayList;
import people.Architect;
import people.Builder;

public class Project {

  private final IBuildingTypeFunctionality building;
  private ArrayList<Architect> architects;
  private ArrayList<people.Builder> builders;
  private ProjectProgress progress;
  private int days;
  private boolean isGoodToGo = true;

  public Project(IBuildingTypeFunctionality building, ArrayList<Architect> architects,
      ArrayList<Builder> builders) {
    this.building = building;
    this.architects = architects;
    this.builders = builders;
    this.days = calculateExactTimeDays();
    this.progress = ProjectProgress.PLANNING;
    updateBuilders();
  }

  public Project(IBuildingTypeFunctionality building, ArrayList<Architect> architects,
      ArrayList<Builder> builders, ProjectProgress progress) {
    this.building = building;
    this.architects = architects;
    this.builders = builders;
    this.days = calculateExactTimeDays();
    this.progress = progress;
    updateBuilders();
  }

  private void updateBuilders() {
    builders.forEach(x -> x.addProject(this));
  }

  private void reload() {
    determineStatus();
    recalculateTime();
  }

  private void determineStatus() {
    if (progress == ProjectProgress.CANCELLED) {
      this.isGoodToGo = false;
    }
  }

  public void recalculateTime() {
    this.days = calculateExactTimeDays();
  }

  public int getDays() {
    return days;
  }

  private int numberOfArchitects() {
    return this.architects.size();
  }

  private int numberOfBuilders() {
    return this.builders.size();
  }

  private int calculateExactTimeDays() {
    int days = (int) (Math.floor(
        building.estimateConstructionTimeDays((Building) building) * (numberOfBuilders() / 100d)));

    if (numberOfArchitects() <= 3) {
      return (int) (days * .75d);
    } else {
      return days;
    }
  }

  public void setArchitects(ArrayList<Architect> architects) {
    this.architects = architects;
    reload();
  }

  public void setBuilders(ArrayList<Builder> builders) {
    this.builders = builders;
    reload();
  }

  public void setProgress(ProjectProgress progress) {
    this.progress = progress;
    reload();
  }

  private void cancel() {
    if (isGoodToGo) {
      setProgress(ProjectProgress.CANCELLED);
    }
  }
}
