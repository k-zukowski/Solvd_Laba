package buildings;

import buildings.abstracts.PrivateBuilding;
import buildings.exceptions.WrongElevatorCountException;
import buildings.interfaces.IBuildingTypeFunctionality;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ApartmentBuilding extends PrivateBuilding implements IBuildingTypeFunctionality {

  private final static Logger logger = LogManager.getLogManager()
      .getLogger("Buildings.ApartmentBuilding");
  private int elevatorCount;

  public ApartmentBuilding(float height, float width, float length, int storyCount,
      boolean isBasement, boolean isUndergroundCarpark, int familyCount, int elevatorCount) {
    super(height, width, length, storyCount, isBasement, isUndergroundCarpark, familyCount);
    this.elevatorCount = elevatorCount;
    try {
      if (elevatorCount <= 0) {
        throw new WrongElevatorCountException(this.getClass().getName(), hashCode(),
            getElevatorCount());
      }
    } catch (WrongElevatorCountException wrongElevatorCountException) {
      this.setElevatorCount(0);
      logger.info(wrongElevatorCountException.toString());
      logger.warning(String.format(
          "Class %s with hashCode = %s,got wrong earthShakeProtection value, ASSIGNING ZERO instead",
          this.getClass().getName(), hashCode()));

    } finally {
      logger.warning(String.format(
          "Class %s with hashCode = %s,got wrong earthShakeProtection value, ASSIGNING ZERO instead",
          this.getClass().getName(), hashCode()));
    }
  }

  public ApartmentBuilding(int familyCount, int elevatorCount) {
    super(familyCount);
    this.elevatorCount = elevatorCount;
  }

  public ApartmentBuilding(int elevatorCount) {
    this.elevatorCount = elevatorCount;
  }

  public ApartmentBuilding() {
  }

  public int getElevatorCount() {
    return elevatorCount;
  }

  public void setElevatorCount(int elevatorCount) {
    this.elevatorCount = elevatorCount;
  }

  @Override
  public String toString() {
    return "Buildings.ApartmentBuilding{" +
        "elevatorCount=" + elevatorCount +
        '}';
  }

  @Override
  public float calculateCost() {
    return 0;
  }

  @Override
  public int estimateConstructionTime() {
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApartmentBuilding testApartmentBuilding = (ApartmentBuilding) o;
    return elevatorCount == testApartmentBuilding.elevatorCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(elevatorCount);
  }
}
