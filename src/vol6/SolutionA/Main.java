package vol6.SolutionA;

import vol6.SolutionA.Plant.FloweringPlant;
import vol6.SolutionA.Garden.Garden;
import vol6.SolutionA.Plant.IndoorPlant;
import vol6.SolutionA.Plant.ShrubPlant;

public class Main {
    public static void main(String[] args) {
        Garden greenhouse = new Garden();
        // Создание кустового растения
        ShrubPlant shrub = new ShrubPlant();
        shrub.setInfo("Кустовая роза", "Европа", "Кустарник", 1.5, 15, "Полутень");
        greenhouse.addPlant(shrub);
        shrub.prune();

        // Создание цветкового растения
        FloweringPlant flower = new FloweringPlant();
        flower.setInfo("Тюльпан", "Азия", "Цветущее", 0.8, 12, "Полное солнце");
        flower.setBloomSeason("Весна");
        greenhouse.addPlant(flower);
        flower.fertilize();

        // Создание комнатного растения
        IndoorPlant indoor = new IndoorPlant();
        indoor.setInfo("Папоротник", "Тропики", "Комнатное", 0.5, 22, "Тень");
        indoor.setPetFriendly(true);
        greenhouse.addPlant(indoor);
        indoor.repot();

        // Вывод информации о всех растениях
        System.out.println("\nВсе растения в оранжерее:");
        greenhouse.getPlants().forEach(plant -> System.out.println(plant.getInfo()));

        // Вывод происхождения растений
        System.out.println("\nРастения из Азии:");
        greenhouse.getPlantsByOrigin("Азия").forEach(plant -> System.out.println(plant.getInfo()));

        // Удаление всех кустовых растений
        System.out.println("\nУдаление всех кустарников:");
        greenhouse.removePlantBySpecies("Кустарник");
        greenhouse.getPlants().forEach(plant -> System.out.println(plant.getInfo()));
    }
}
