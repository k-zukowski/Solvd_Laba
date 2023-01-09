package buildings;

import buildings.exceptions.WrongElevatorCountException;
import buildings.interfaces.IBuildingTypeFunctionality;
import people.Architect;
import people.Builder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ApartmentBuildingFunctionality extends PrivateBuilding implements IBuildingTypeFunctionality {

    private final static Logger logger = LogManager.getLogManager().getLogger("Buildings.ApartmentBuilding");
    private int elevatorCount;

    public ApartmentBuildingFunctionality(float height, float width, float length, int storyCount, boolean isBasement, boolean isUndergroundCarpark, ArrayList<Architect> architects, ArrayList<Builder> builders, int familyCount, int elevatorCount) {
        super(height, width, length, storyCount, isBasement, isUndergroundCarpark, architects, builders, familyCount);
        this.elevatorCount = elevatorCount;
        try {
            if (elevatorCount <= 0) {
                throw new WrongElevatorCountException(this.getClass().getName(), hashCode(), getElevatorCount());
            }
        } catch (WrongElevatorCountException wrongElevatorCountException) {
            this.setElevatorCount(0);
            logger.info(wrongElevatorCountException.toString());
            logger.warning(String.format("Class %s with hashCode = %s,got wrong earthShakeProtection value, ASSIGNING ZERO instead", this.getClass().getName(), hashCode()));

        } finally {
            logger.warning(String.format("Class %s with hashCode = %s,got wrong earthShakeProtection value, ASSIGNING ZERO instead", this.getClass().getName(), hashCode()));
        }
    }

    public ApartmentBuildingFunctionality(int familyCount, int elevatorCount) {
        super(familyCount);
        this.elevatorCount = elevatorCount;
    }

    public ApartmentBuildingFunctionality(int elevatorCount) {
        this.elevatorCount = elevatorCount;
    }

    public ApartmentBuildingFunctionality() {
    }

    public int getElevatorCount() {
        return elevatorCount;
    }

    public void setElevatorCount(int elevatorCount) {
        this.elevatorCount = elevatorCount;
    }

    @Override
    public String toString() {
        return "Buildings.ApartmentBuilding{" +
                "elevatorCount=" + elevatorCount +
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentBuildingFunctionality testApartmentBuilding = (ApartmentBuildingFunctionality) o;
        return elevatorCount == testApartmentBuilding.elevatorCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elevatorCount);
    }
}
