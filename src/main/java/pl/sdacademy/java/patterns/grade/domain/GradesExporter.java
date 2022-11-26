package pl.sdacademy.java.patterns.grade.domain;

import java.io.OutputStream;
import java.util.List;

// adapter example
public interface GradesExporter {
    void exportGrades(List<Grade> grades, OutputStream outputStream);
    boolean supportsFormat(ExportFormat exportFormat);
}
