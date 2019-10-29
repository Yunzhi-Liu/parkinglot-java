package club.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LengthTest {

    @Test
    void should_be_true_when_comparing_one_and_one() {
        final Length one = new Length(1);

        final boolean result = one.isEquals(one);

        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_when_comparing_one_and_two() {
        final Length one = new Length(1);
        final Length two = new Length(2);

        final boolean result = one.isEquals(two);

        assertThat(result).isFalse();
    }
}