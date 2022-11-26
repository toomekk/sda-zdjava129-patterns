package pl.sdacademy.java.external;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CsvWriterTest {

    @Test
    void shouldWriteToGivenOutput() {
        //GIVEN
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //WHEN
        final List<List<String>> data = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        CsvWriter.export(data, outputStream);

        //THEN
        assertThat(outputStream.toString(StandardCharsets.UTF_8)).isEqualToIgnoringWhitespace("""
            a,b
            c,d
        """);
    }
}
