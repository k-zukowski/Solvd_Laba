package orders;

import buildings.abstracts.Building;
import buildings.interfaces.IBuildingTypeFunctionality;
import java.time.LocalDateTime;
import java.util.ArrayList;
import people.Architect;
import people.Builder;

public class Order {

  private final ArrayList<? extends IBuildingTypeFunctionality> buildings;
  private final String description;
  private final LocalDateTime deadline;
  private final boolean parallelism;
  private ArrayList<Project> projects = new ArrayList<>();

  public Order(ArrayList<? extends IBuildingTypeFunctionality> buildings, String description,
      LocalDateTime deadline, boolean parallelism) {
    this.buildings = buildings;
    this.description = description;
    this.deadline = deadline;
    this.parallelism = parallelism;
  }
  public Order(ArrayList<? extends IBuildingTypeFunctionality> buildings, String description,
      LocalDateTime deadline) {
    this.buildings = buildings;
    this.description = description;
    this.deadline = deadline;
    this.parallelism = true;
  }

  public <T extends Building> long getEstimatedTimeDays() {
    int time = 0;
    if (parallelism) {
      for (IBuildingTypeFunctionality building : buildings) {
        time += building.estimateConstructionTimeDays((Building) building);
      }
    } else {
      for (IBuildingTypeFunctionality building : buildings) {
        int temp = building.estimateConstructionTimeDays((Building) building);
        if (temp > time) {
          time = temp;
        }
      }
    }
    return time;
  }

  public <T extends Building> float getEstimatedCostK() {
    float cost = 0F;
    for (IBuildingTypeFunctionality building : buildings) {
      cost += building.calculateCostK((Building) building);
    }
    return cost;
  }

  public  <T extends IBuildingTypeFunctionality> void setProjectResources(T building,
      ArrayList<Builder> builders, ArrayList<Architect> architects) {
    for (IBuildingTypeFunctionality currBuilding : buildings) {
      if (currBuilding.equals(building)) {
        Project project = new Project(currBuilding, architects, builders);
        projects.add(project);
      }
    }
  }

  public ArrayList<Project> getProjects() {
    return projects;
  }
}
