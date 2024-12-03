package vol4.solutionA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {
    private String name;
    private City capital;
    private List<Region> regions;

    public State(String name, City capital) {
        this.name = name;
        this.capital = capital;
        this.regions = new ArrayList<>();
    }

    public void addRegion(Region region) {
        regions.add(region);
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public int getRegionCount() {
        return regions.size();
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Region region : regions) {
            totalArea += region.getArea();
        }
        return totalArea;
    }

    public List<City> getRegionalCenters() {
        List<City> regionalCenters = new ArrayList<>();
        for (Region region : regions) {
            regionalCenters.add(region.getRegionalCenter());
        }
        return regionalCenters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name) &&
                Objects.equals(capital, state.capital) &&
                Objects.equals(regions, state.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, regions);
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", regions=" + regions +
                '}';
    }
}
