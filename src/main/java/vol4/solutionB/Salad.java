package vol4.solutionB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Salad {
    private List<Vegetable> ingredients;

    public Salad() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Vegetable vegetable) {
        ingredients.add(vegetable);
    }

    public double getTotalCalories() {
        return ingredients.stream().mapToDouble(Vegetable::getCalories).sum();
    }

    public void sortIngredientsByWeight() {
        ingredients.sort(Comparator.comparingDouble(Vegetable::getWeight));
    }

//    Поиск овощей в заданном диапазоне ккал
    public List<Vegetable> findVegetablesByCaloriesRange(double minCalories, double maxCalories) {
        return ingredients.stream()
                .filter(veg -> veg.getCalories() >= minCalories && veg.getCalories() <= maxCalories)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ингредиенты салата: " + ingredients;
    }
}