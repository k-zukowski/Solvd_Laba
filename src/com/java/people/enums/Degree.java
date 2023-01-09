package people.enums;

public enum Degree {
    LOW("1"), MID("2"), HIGH("3");//Number because it later determines one's wage.

    private final int type;

    Degree(String type) {
        this.type = Integer.parseInt(type);
    }

    public int getType() {
        return type;
    }
}
