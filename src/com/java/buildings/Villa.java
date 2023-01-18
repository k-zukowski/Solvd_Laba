package buildings;

import buildings.abstracts.Building;
import buildings.interfaces.IBuildingTypeFunctionality;

public class Villa extends Building implements IBuildingTypeFunctionality {

  private int poolCount;
  private boolean isCarGarage;

  public Villa(float height, float width, float length, int storyCount, boolean isBasement,
      boolean isUndergroundCarpark, int poolCount, boolean isCarGarage) {
    super(height, width, length, storyCount, isBasement, isUndergroundCarpark);
    this.poolCount = poolCount;
    this.isCarGarage = isCarGarage;
  }

  public Villa(int poolCount, boolean isCarGarage) {
    this.poolCount = poolCount;
    this.isCarGarage = isCarGarage;
  }

  public Villa() {
  }

  public int getPoolCount() {
    return poolCount;
  }

  public void setPoolCount(int poolCount) {
    this.poolCount = poolCount;
  }

  public boolean isCarGarage() {
    return isCarGarage;
  }

  public void setCarGarage(boolean carGarage) {
    isCarGarage = carGarage;
  }

  @Override
  public String toString() {
    return "Buildings.Villa{" +
        "poolCount=" + poolCount +
        ", isCarGarage=" + isCarGarage +
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
    if (o == null || getClass() != o.getClass() || this.hashCode() != o.hashCode()) {
      return false;
    }
    Villa villa = (Villa) o;
    return poolCount == villa.poolCount &&
        isCarGarage == villa.isCarGarage &&
        getHeight() == villa.getHeight() &&
        getStoryCount() == villa.getStoryCount();
  }

  @Override
  public int hashCode() {
    int hash = 12;
    hash += poolCount * 45;
    hash -= getStoryCount();
    hash += getHeight();
    return hash;
  }
}
