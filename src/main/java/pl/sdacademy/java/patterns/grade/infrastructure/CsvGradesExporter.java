package pl.sdacademy.java.patterns.grade.infrastructure;

import pl.sdacademy.java.external.CsvWriter;
import pl.sdacademy.java.patterns.grade.domain.ExportFormat;
import pl.sdacademy.java.patterns.grade.domain.Grade;
import pl.sdacademy.java.patterns.grade.domain.GradesExporter;

import java.io.OutputStream;
import java.util.List;

public class CsvGradesExporter implements GradesExporter {

    private static final CsvGradesExporter instance = new CsvGradesExporter();

    public static GradesExporter getInstance() {
        return instance;
    }

    private CsvGradesExporter() {}

    @Override
    public void exportGrades(List<Grade> grades, OutputStream outputStream) {
        final List<List<String>> csvData = grades.stream()
            .map(grade -> List.of(
                grade.getCourseUuid().toString(),
                grade.getGradeType().name(),
                grade.getIssueDateTime().toString(),
                grade.getValue().toString()
            ))
            .toList();

        CsvWriter.export(csvData, outputStream);
    }

    @Override
    public boolean supportsFormat(ExportFormat exportFormat) {
        return exportFormat == ExportFormat.CSV;
    }
}
