package vol6.solutionA.plant;

//  Базовый класс AbstractPlant
public abstract class AbstractPlant implements Plant {
    protected String name;
    protected String origin;
    protected String species;
    protected double waterNeed;
    protected double temperature;
    protected String lighting;

    @Override
    public void setInfo(String name, String origin, String species, double waterNeed, double temperature, String lighting) {
        this.name = name;
        this.origin = origin;
        this.species = species;
        this.waterNeed = waterNeed;
        this.temperature = temperature;
        this.lighting = lighting;
    }

    @Override
    public void updateInfo(String name, String origin, String species, double waterNeed, double temperature, String lighting) {
        setInfo(name, origin, species, waterNeed, temperature, lighting);
    }

    @Override
    public String getInfo() {
        return String.format("Имя: %s, Происхождение: %s, Вид: %s, Потребность в воде: %.2f л, Температура: %.2f°C, Освещение: %s",
                name, origin, species, waterNeed, temperature, lighting);
    }

    @Override
    public void water() {
        System.out.println("'" + name + "' полито количеством воды: " + waterNeed + " литров");
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("Для '" + name + "' установлена температура: " + temperature + "°C");
    }

    @Override
    public void setLighting(String lighting) {
        this.lighting = lighting;
        System.out.println("Для '" + name + "' установлено освещение: " + lighting);
    }
}
