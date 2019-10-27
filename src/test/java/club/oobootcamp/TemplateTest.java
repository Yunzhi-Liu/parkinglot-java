package club.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemplateTest {
    @Test
    void test_equals() {
        assertThat(1).isEqualTo(new Integer(1));
    }

    @Test
    void test_exception() {
        assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException();
        });
    }
}
