import java.util.Objects;

public class Auto {

    String brand;
    String color;

    public Auto(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return Objects.equals(brand, auto.brand) &&
                    Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }
}
