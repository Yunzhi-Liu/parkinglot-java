package club.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LengthTest {

    @Test
    void should_be_true_when_judged_one_is_equal_to_one() {
        final Length one = new Length(1);

        final boolean result = one.isEquals(one);

        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_when_judged_one_is_equal_to_two() {
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
    void should_be_true_when_judged_one_cm_is_equal_to_one_cm() {
        final Length oneCM = new Length(1, "cm");

        final boolean result = oneCM.isEquals(oneCM);

        assertThat(result).isTrue();
    }
}
