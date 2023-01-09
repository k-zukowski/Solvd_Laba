package buildings;

import buildings.interfaces.IBuildingTypeFunctionality;
import people.Architect;
import people.Builder;

import java.util.ArrayList;

public class DetachedHouse extends PrivateBuilding implements IBuildingTypeFunctionality {

    private boolean isElevator;

    public DetachedHouse(float height, float width, float length, int storyCount, boolean isBasement, boolean isUndergroundCarpark, ArrayList<Architect> architects, ArrayList<Builder> builders, int familyCount, boolean isElevator) {
        super(height, width, length, storyCount, isBasement, isUndergroundCarpark, architects, builders, familyCount);
        this.isElevator = isElevator;
    }

    public DetachedHouse(int familyCount, boolean isElevator) {
        super(familyCount);
        this.isElevator = isElevator;
    }

    public DetachedHouse(boolean isElevator) {
        this.isElevator = isElevator;
    }

    public DetachedHouse() {
    }

    public boolean isElevator() {
        return isElevator;
    }

    public void setElevator(boolean elevator) {
        isElevator = elevator;
    }

    @Override
    public String toString() {
        return "Buildings.DetachedHouse{" +
                "isElevator=" + isElevator +
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
