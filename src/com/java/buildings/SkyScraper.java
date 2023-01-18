package buildings;

import buildings.abstracts.Building;
import buildings.enums.SkyScraperType;
import buildings.exceptions.WrongEarthShakeProtectionException;
import buildings.interfaces.IBuildingTypeFunctionality;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SkyScraper extends Building implements IBuildingTypeFunctionality {

  private final static Logger logger = LogManager.getLogManager().getLogger("Buildings.SkyScraper");
  private SkyScraperType type;
  private int earthShakeProtection;

  public SkyScraper(float height, float width, float length, int storyCount, boolean isBasement,
      boolean isUndergroundCarpark, SkyScraperType type, int earthShakeProtection) {
    super(height, width, length, storyCount, isBasement, isUndergroundCarpark);
    this.type = type;
    this.earthShakeProtection = earthShakeProtection;
    try {
      if (earthShakeProtection < 0 || earthShakeProtection > 10) {
        throw new WrongEarthShakeProtectionException(this.getClass().getName(), hashCode(),
            getEarthShakeProtection());
      }
    } catch (WrongEarthShakeProtectionException wrongEarthShakeProtectionException) {
      logger.info(wrongEarthShakeProtectionException.toString());
      this.earthShakeProtection = 0;
    } finally {
      logger.warning(String.format(
          "Class %s with hashCode = %s,got wrong earthShakeProtection value, ASSIGNING ZERO instead",
          this.getClass().getName(), hashCode()));
    }
  }

  public SkyScraper(SkyScraperType type, int earthShakeProtection) {
    this.type = type;
    this.earthShakeProtection = earthShakeProtection;
  }

  public SkyScraper() {
  }

  public SkyScraperType getType() {
    return type;
  }

  public void setType(SkyScraperType type) {
    this.type = type;
  }

  public int getEarthShakeProtection() {
    return earthShakeProtection;
  }

  public void setEarthShakeProtection(int earthShakeProtection) {
    this.earthShakeProtection = earthShakeProtection;
  }

  @Override
  public String toString() {
    return "Buildings.SkyScraper{" +
        "type=" + type +
        ", earthShakeProtection=" + earthShakeProtection +
        '}';
  }

  @Override
  public float calculateCost() {
    float tempCost = volume() * 4;
    if (earthShakeProtection != 0) {
      tempCost *= earthShakeProtection;
    }
    if (isHasUndergroundCarpark()) {
      tempCost += area();
    }
    tempCost *= type.getType();
    return tempCost;
  }

  @Override
  public int estimateConstructionTime() {
    var a = volume() * earthShakeProtection;
    return (int) Math.ceil(a);
  }

  @Override
  public int hashCode() {
    int hash = 69;
    hash += type.getType() == 1 ? 1 : 0;
    hash *= earthShakeProtection == 5 ? 2 : 3;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass() || this.hashCode() != obj.hashCode()) {
      return false;
    }
    SkyScraper testSkyScraper = (SkyScraper) obj;
    return
        this.type == testSkyScraper.type &&
            this.earthShakeProtection == testSkyScraper.earthShakeProtection &&
            this.getHeight() == testSkyScraper.getHeight() &&
            this.volume() == testSkyScraper.volume();
  }
}
