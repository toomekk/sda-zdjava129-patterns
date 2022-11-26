package pl.sdacademy.java.patterns.grade.domain;

import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

public class GradeExportService {
    private final GradeRepository gradeRepository;
    private final List<GradesExporter> gradesExporters;

    public GradeExportService(
        GradeRepository gradeRepository,
        List<GradesExporter> gradesExporters
    ) {
        this.gradeRepository = gradeRepository;
        this.gradesExporters = gradesExporters;
    }

    public void export(UUID courseUuid, ExportFormat exportFormat, OutputStream outputStream) {
        final List<Grade> grades = gradeRepository.findGradesByCourseUuid(courseUuid);

        for (GradesExporter gradesExporter : gradesExporters) {
            if (gradesExporter.supportsFormat(exportFormat)) {
                gradesExporter.exportGrades(grades, outputStream);
                return;
            }
        }

        throw new IllegalArgumentException(exportFormat.name());
    }

}
