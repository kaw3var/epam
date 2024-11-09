package vol6.SolutionA.Garden;

import vol6.SolutionA.Plant.Plant;

import java.util.List;

//  Интерфейс оранжереи
public interface GardenManagment {
    void addPlant(Plant plant);

    //  Удаление растения по виду
    void removePlantBySpecies(String species);

    List<Plant> getPlants();

    //  Возвращает список растений определенного вида
    List<Plant> getPlantsBySpecies(String species);

    //  Возвращает список растений из определенного места происхождения
    List<Plant> getPlantsByOrigin(String origin);
}

