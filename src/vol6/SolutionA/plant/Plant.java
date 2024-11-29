package vol6.SolutionA.plant;

public interface Plant {
    void setInfo(String name, String origin, String species, double waterNeed, double temperature, String lighting);
    void updateInfo(String name, String origin, String species, double waterNeed, double temperature, String lighting);
    String getInfo();
    void water();
    void setTemperature(double temperature);
    void setLighting(String lighting);
}
