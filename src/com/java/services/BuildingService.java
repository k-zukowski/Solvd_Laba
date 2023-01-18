package services;

import buildings.abstracts.Building;

public class BuildingService {

  public <T extends Building> double calculateDiagonal(T building) {
    return Math.sqrt(
        (Math.pow(building.getWidth(), 2)) +
            (Math.pow(building.getLength(), 2)) +
            (Math.pow(building.getHeight(), 2))
    );
  }

  public <T extends Building> double calculateEstimatedConcrete(T building) {
    double out = 0d;
    switch (building.getClass().getName()) {
      case ("Buildings.Hotel") -> out = building.area() * .47d;
      case ("Buildings.Magazine") -> out = building.area() * .80d;
      case ("Buildings.Villa") -> out = building.area() * .73d;
    }
    return out;
  }

}
