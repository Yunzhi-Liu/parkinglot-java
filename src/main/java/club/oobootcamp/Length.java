package club.oobootcamp;

public class Length {

    private final int value;

    public Length(final int value) {
        this.value = value;
    }

    public boolean isEquals(final Length other) {
        return this.value == other.value;
    }
}
