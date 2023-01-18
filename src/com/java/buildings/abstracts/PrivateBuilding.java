package buildings.abstracts;

public abstract class PrivateBuilding extends Building {

  private int familyCount;

  public PrivateBuilding(float height, float width, float length, int storyCount,
      boolean isBasement, boolean isUndergroundCarpark, int familyCount) {
    super(height, width, length, storyCount, isBasement, isUndergroundCarpark);
    this.familyCount = familyCount;
  }

  public PrivateBuilding(int familyCount) {
    this.familyCount = familyCount;
  }

  public PrivateBuilding() {
  }

  public int getFamilyCount() {
    return familyCount;
  }

  public void setFamilyCount(int familyCount) {
    this.familyCount = familyCount;
  }

  @Override
  public String toString() {
    return "Buildings.PrivateBuilding{" +
        "familyCount=" + familyCount +
        '}';
  }

}
