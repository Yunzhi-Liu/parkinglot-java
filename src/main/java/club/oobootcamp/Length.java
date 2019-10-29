package club.oobootcamp;

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
        return this.value > other.value;
    }
}
