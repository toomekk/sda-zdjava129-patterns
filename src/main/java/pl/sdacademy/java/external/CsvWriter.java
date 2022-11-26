package pl.sdacademy.java.external;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWriter {

    private CsvWriter() {
        throw new UnsupportedOperationException();
    }

    /**
     * Exports given {@code data} to CSV format and prints out the result on the standard output.
     * This is meant to be an external utility class, but IS NOT A RELIABLE IMPLEMENTATION
     * (need to take care of commas and normally use of quotes is highly recommended).
     */
    public static void export(List<List<String>> data, OutputStream outputStream) {
        String csv = data.stream()
                .map(row -> String.join(",", row))
                .collect(Collectors.joining("\n"));

        new PrintStream(outputStream).println(csv);
    }
}
