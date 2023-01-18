package buildings.abstracts;

import buildings.exceptions.ValidateBuildingDimensionsException;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import people.Architect;
import people.Builder;

public abstract class Building {

  private final static Logger logger = LogManager.getLogManager()
      .getLogger("Buildings.Abstracts.Building");
  private float height;
  private float width;
  private float length;
  private int storyCount;
  private boolean hasBasement;
  private boolean hasUndergroundCarpark;
  private ArrayList<people.Architect> architects;
  private ArrayList<people.Builder> builders;

  public Building(float height, float width, float length, int storyCount, boolean hasBasement,
      boolean hasUndergroundCarpark) {
    this.height = height;
    this.width = width;
    this.length = length;
    this.storyCount = storyCount;
    this.hasBasement = hasBasement;
    this.hasUndergroundCarpark = hasUndergroundCarpark;
    validateDimensions();
  }

  public Building() {
  }

  private void validateDimensions() {
    try {
      if (getHeight() < 0 || getLength() < 0 || getWidth() < 0) {
        throw new ValidateBuildingDimensionsException(this.getClass().getName(), hashCode(),
            getLength(),
            getWidth(),
            getHeight()
        );
      }
    } catch (ValidateBuildingDimensionsException exception) {
      setLength(0f);
      setWidth(0f);
      setHeight(0f);
    } finally {
      logger.warning("class has been assigned wrong values setting them to zero");
    }
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public float getWidth() {
    return width;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }

  public int getStoryCount() {
    return storyCount;
  }

  public void setStoryCount(int storyCount) {
    this.storyCount = storyCount;
  }

  public boolean isHasBasement() {
    return hasBasement;
  }

  public void setHasBasement(boolean hasBasement) {
    this.hasBasement = hasBasement;
  }

  public boolean isHasUndergroundCarpark() {
    return hasUndergroundCarpark;
  }

  public void setHasUndergroundCarpark(boolean hasUndergroundCarpark) {
    this.hasUndergroundCarpark = hasUndergroundCarpark;
  }

  public ArrayList<Architect> getArchitects() {
    return architects;
  }

  public void setArchitects(ArrayList<Architect> architects) {
    this.architects = architects;
  }

  public ArrayList<Builder> getBuilders() {
    return builders;
  }

  public void setBuilders(ArrayList<Builder> builders) {
    this.builders = builders;
  }

  @Override
  public String toString() {
    return "Buildings.Abstracts.Building{" +
        "height=" + height +
        ", width=" + width +
        ", length=" + length +
        ", storyCount=" + storyCount +
        ", isBasement=" + hasBasement +
        ", isUndergroundCarpark=" + hasUndergroundCarpark +
        ", architects=" + architects +
        ", builders=" + builders +
        '}';
  }

  public float volume() {
    return (this.height *
        this.width *
        this.length);
  }

  public float getheightOfFloor() {
    return height / storyCount;
  }

  public float area() {
    return (this.height * this.width);
  }
}