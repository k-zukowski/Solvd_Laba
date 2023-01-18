package buildings;

import buildings.abstracts.Building;
import buildings.interfaces.IBuildingTypeFunctionality;

public class Hotel extends Building implements IBuildingTypeFunctionality {

  private int roomCount;

  public Hotel(float height, float width, float length, int storyCount, boolean isBasement,
      boolean isUndergroundCarpark, int roomCount) {
    super(height, width, length, storyCount, isBasement, isUndergroundCarpark);
    this.roomCount = roomCount;
  }

  public Hotel(int roomCount) {
    this.roomCount = roomCount;
  }

  public Hotel() {
  }

  public int getRoomCount() {
    return roomCount;
  }

  public void setRoomCount(int roomCount) {
    this.roomCount = roomCount;
  }

  @Override
  public String toString() {
    return "Buildings.Hotel{" +
        "roomCount=" + roomCount +
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
}
