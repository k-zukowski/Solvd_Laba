package buildings.interfaces;

import buildings.abstracts.Building;

public interface IBuildingTypeFunctionality {
    default <T extends Building> float calculateCostK(T building){
        return (building.area() * building.getHeight() * building.getStoryCount())/1000;
    }

    default <T extends Building> int estimateConstructionTimeDays(T building){
        return (int)((building.getStoryCount() * building.volume() * (building.getheightOfFloor()* .69f)))/60;
    }

    float calculateCost();

    int estimateConstructionTime();
}
