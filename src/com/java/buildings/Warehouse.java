package buildings;

import buildings.abstracts.Building;
import buildings.interfaces.IBuildingTypeFunctionality;
import people.Architect;
import people.Builder;

import java.util.ArrayList;

public class Warehouse extends Building implements IBuildingTypeFunctionality {

    private float roofAngle;

    public Warehouse(float height, float width, float length, int storyCount, boolean isBasement, boolean isUndergroundCarpark, ArrayList<Architect> architects, ArrayList<Builder> builders, float roofAngle) {
        super(height, width, length, storyCount, isBasement, isUndergroundCarpark, architects, builders);
        this.roofAngle = roofAngle;
    }

    public Warehouse(float roofAngle) {
        this.roofAngle = roofAngle;
    }

    public Warehouse() {
    }

    public float getRoofAngle() {
        return roofAngle;
    }

    public void setRoofAngle(float roofAngle) {
        this.roofAngle = roofAngle;
    }

    @Override
    public String toString() {
        return "Buildings.Magazine{" +
                "roofAngle=" + roofAngle +
                '}';
    }

    @Override
    public float calculateCost() {
        return volume() * roofAngle;
    }

    @Override
    public int estimateConstructionTime() {
        return 0;
    }
}
