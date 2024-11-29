package vol4.solutionA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Класс Область
public class Region {
    private String name;
    private double area; // площадь области в км²
    private City regionalCenter;
    private List<District> districts;

    public Region(String name, double area, City regionalCenter) {
        this.name = name;
        this.area = area;
        this.regionalCenter = regionalCenter;
        this.districts = new ArrayList<>();
    }

    public void addDistrict(District district) {
        districts.add(district);
    }

    public double getArea() {
        return area;
    }

    public City getRegionalCenter() {
        return regionalCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.area, area) == 0 &&
                Objects.equals(name, region.name) &&
                Objects.equals(regionalCenter, region.regionalCenter) &&
                Objects.equals(districts, region.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, regionalCenter, districts);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", regionalCenter=" + regionalCenter +
                ", districts=" + districts +
                '}';
    }
}
