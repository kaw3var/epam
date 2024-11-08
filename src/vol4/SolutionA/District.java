package vol4.SolutionA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Класс Район
public class District {
    private String name;
    private List<City> cities;

    public District(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(name, district.name) &&
                Objects.equals(cities, district.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cities);
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
