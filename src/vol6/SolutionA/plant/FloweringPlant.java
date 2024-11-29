package vol6.SolutionA.plant;

//  Цветковое растение
public class FloweringPlant extends AbstractPlant {
    private String bloomSeason;

    public void setBloomSeason(String season) {
        this.bloomSeason = season;
    }

    public String getBloomSeason() {
        return bloomSeason;
    }

    // Удобрение растения
    public void fertilize() {
        System.out.println("Цветковое растение '" + name + "' удобрено");
    }
}
