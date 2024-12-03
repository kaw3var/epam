package vol6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vol6.solutionA.garden.Garden;
import vol6.solutionA.plant.FloweringPlant;
import vol6.solutionA.plant.IndoorPlant;
import vol6.solutionA.plant.Plant;
import vol6.solutionA.plant.ShrubPlant;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest {

    private Garden garden;

    @BeforeEach
    void setUp() {
        garden = new Garden();
    }

    @Test
    void testAddPlant() {
        Plant plant = createFloweringPlant();
        garden.addPlant(plant);

        assertEquals(1, garden.getPlants().size());
        assertTrue(garden.getPlants().contains(plant));
    }

    @Test
    void testRemovePlantBySpecies() {
        Plant plant1 = createFloweringPlant();
        Plant plant2 = createShrubPlant();
        garden.addPlant(plant1);
        garden.addPlant(plant2);

        garden.removePlantBySpecies("Цветковое");
        List<Plant> remainingPlants = garden.getPlants();

        assertEquals(1, remainingPlants.size());
        assertFalse(remainingPlants.contains(plant1));
        assertTrue(remainingPlants.contains(plant2));
    }

    @Test
    void testGetPlantsBySpecies() {
        Plant plant1 = createFloweringPlant();
        Plant plant2 = createShrubPlant();
        garden.addPlant(plant1);
        garden.addPlant(plant2);

        List<Plant> floweringPlants = garden.getPlantsBySpecies("Цветковое");

        assertEquals(1, floweringPlants.size());
        assertTrue(floweringPlants.contains(plant1));
    }

    @Test
    void testGetPlantsByOrigin() {
        Plant plant1 = createFloweringPlant();
        Plant plant2 = createIndoorPlant();
        garden.addPlant(plant1);
        garden.addPlant(plant2);

        List<Plant> tropicalPlants = garden.getPlantsByOrigin("Тропики");

        assertEquals(1, tropicalPlants.size());
        assertTrue(tropicalPlants.contains(plant1));
    }

    private Plant createFloweringPlant() {
        FloweringPlant floweringPlant = new FloweringPlant();
        floweringPlant.setInfo("Роза", "Тропики", "Цветковое", 2.5, 25.0, "Солнечное");
        return floweringPlant;
    }

    private Plant createShrubPlant() {
        ShrubPlant shrubPlant = new ShrubPlant();
        shrubPlant.setInfo("Кустарник", "Север", "Кустовое", 1.0, 15.0, "Полутень");
        return shrubPlant;
    }

    private Plant createIndoorPlant() {
        IndoorPlant indoorPlant = new IndoorPlant();
        indoorPlant.setInfo("Фикус", "Азия", "Комнатное", 1.5, 20.0, "Искусственное");
        return indoorPlant;
    }
}
