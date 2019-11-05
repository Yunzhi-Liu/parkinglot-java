package club.oobootcamp.length;

import java.util.Objects;

public class Length {

    private final int value;
    private final String unit;

    public Length(final int value) {
        this.value = value;
        this.unit = "";
    }

    public Length(final int value, final String unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean isEquals(final Length other) {
        return this.value == other.value;
    }

    public boolean isLessThan(final Length other) {
        return this.value < other.value;
    }

    public boolean isMoreThan(final Length other) {
        if (this.unit.equals(other.unit)) {
            return this.value > other.value;
        }
        return convertToCentimeter().value > other.convertToCentimeter().value;
    }

    public Length convertToCentimeter() {
        if (unit.equals("cm")) {
            return this;
        }
        return new Length(value * 100, "cm");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Length)) {
            return false;
        }
        final Length length = (Length) o;
        return value == length.value && Objects.equals(unit, length.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
