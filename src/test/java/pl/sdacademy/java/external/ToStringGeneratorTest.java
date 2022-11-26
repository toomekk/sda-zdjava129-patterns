package pl.sdacademy.java.external;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToStringGeneratorTest {

    @Test
    void shouldGenerateExistingObject() {
        //WHEN
        final String result = ToStringGenerator.shallowToString(new Example());

        //THEN
        assertThat(result).isEqualToIgnoringWhitespace("""
            pl.sdacademy.java.external.ToStringGeneratorTest$Example {
                foo = fooValue
                bar = 3
            }
        """);
    }

    private static class Example {
        private String foo = "fooValue";
        private int bar = 3;
    }
}
