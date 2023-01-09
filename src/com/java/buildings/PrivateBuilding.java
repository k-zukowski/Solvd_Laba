package buildings;

import buildings.abstracts.Building;
import people.Architect;
import people.Builder;

import java.util.ArrayList;

public class PrivateBuilding extends Building {

    private int familyCount;

    public PrivateBuilding(float height, float width, float length, int storyCount, boolean isBasement, boolean isUndergroundCarpark, ArrayList<Architect> architects, ArrayList<Builder> builders, int familyCount) {
        super(height, width, length, storyCount, isBasement, isUndergroundCarpark, architects, builders);
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
