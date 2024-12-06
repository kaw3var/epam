package vol13.solutionA;

import java.sql.Date;

public class Person {
    private int id;
    private String fullName;
    private Date birthDate;

    public Person(int id, String fullName, Date birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
