package buildings.enums;

public enum SkyScraperType {
  FANCY("3"), BASIC("2"), BUDGET("1");

  private final int type;

  SkyScraperType(String type) {
    this.type = Integer.parseInt(type);
  }

  public int getType() {
    return type;
  }
}
