package pl.sdacademy.java.patterns.grade.infrastructure;

import pl.sdacademy.java.external.ToStringGenerator;
import pl.sdacademy.java.patterns.grade.domain.ExportFormat;
import pl.sdacademy.java.patterns.grade.domain.Grade;
import pl.sdacademy.java.patterns.grade.domain.GradesExporter;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class StringGradesExporter implements GradesExporter {
    private static final StringGradesExporter instance = new StringGradesExporter();

    public static GradesExporter getInstance() {
        return instance;
    }

    private StringGradesExporter() {}

    @Override
    public void exportGrades(List<Grade> grades, OutputStream outputStream) {
        PrintStream printStream = new PrintStream(outputStream);
        grades.stream()
            .map(ToStringGenerator::shallowToString)
            .forEach(printStream::println);
    }

    @Override
    public boolean supportsFormat(ExportFormat exportFormat) {
        return exportFormat == ExportFormat.STRING;
    }
}
