package club.oobootcamp.length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LengthTest {

    @Test
    void should_be_true_when_judged_that_one_is_equal_to_one() {
        final Length one = new Length(1);

        final boolean result = one.isEquals(one);

        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_when_judged_that_one_is_equal_to_two() {
        final Length one = new Length(1);
        final Length two = new Length(2);

        final boolean result = one.isEquals(two);

        assertThat(result).isFalse();
    }

    @Test
    void should_be_true_when_judged_that_one_is_less_than_two() {
        final Length one = new Length(1);
        final Length two = new Length(2);

        final boolean result = one.isLessThan(two);

        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_when_judged_that_three_is_less_than_two() {
        final Length three = new Length(3);
        final Length two = new Length(2);

        final boolean result = three.isLessThan(two);

        assertThat(result).isFalse();
    }

    @Test
    void should_be_false_when_judged_that_one_is_more_than_two() {
        final Length one = new Length(1);
        final Length two = new Length(2);

        final boolean result = one.isMoreThan(two);

        assertThat(result).isFalse();
    }

    @Test
    void should_be_true_when_judged_that_three_is_more_than_two() {
        final Length three = new Length(3);
        final Length two = new Length(2);

        final boolean result = three.isMoreThan(two);

        assertThat(result).isTrue();
    }

    @Test
    void should_be_true_when_judged_that_one_centimeter_is_equal_to_one_centimeter() {
        final Length oneCentimeter = new Length(1, "cm");

        final boolean result = oneCentimeter.isEquals(oneCentimeter);

        assertThat(result).isTrue();
    }

    @Test
    void should_return_hundred_centimeters_when_converting_one_meter_to_centimeters() {
        final Length oneMeter = new Length(1, "m");

        final Length actualLength = oneMeter.convertToCentimeter();

        assertThat(actualLength).isEqualTo(new Length(100, "cm"));
    }

    @Test
    void should_be_true_when_judged_that_one_meter_is_more_than_ten_centimeters() {
        final Length oneMeter = new Length(1, "m");
        final Length tenCentimeters = new Length(10, "cm");

        final boolean result = oneMeter.isMoreThan(tenCentimeters);

        assertThat(result).isTrue();
    }
}
