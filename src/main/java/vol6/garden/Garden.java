package vol6.garden;

import vol6.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//  Класс Garden (Сад)
public class Garden implements GardenManagment {
    private List<Plant> plants = new ArrayList<>();

    @Override
    public void addPlant(Plant plant) {
        plants.add(plant);
        System.out.println(plant.getInfo() + " Добавлено в оранжерею");
    }

    @Override
    public void removePlantBySpecies(String species) {
        plants = plants.stream()
                .filter(plant -> !plant.getInfo().contains("Вид: " + species))
                .collect(Collectors.toList());
        System.out.println("Все растения вида '" + species + "' удалены");
    }

    @Override
    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public List<Plant> getPlantsBySpecies(String species) {
        return plants.stream()
                .filter(plant -> plant.getInfo().contains("Вид: " + species))
                .collect(Collectors.toList());
    }

    @Override
    public List<Plant> getPlantsByOrigin(String origin) {
        return plants.stream()
                .filter(plant -> plant.getInfo().contains("Происхождение: " + origin))
                .collect(Collectors.toList());
    }
}
