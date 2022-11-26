package pl.sdacademy.java.patterns.grade.domain;

import pl.sdacademy.java.external.CsvWriter;
import pl.sdacademy.java.external.ToStringGenerator;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.UUID;

public class GradeExportService {
    private final GradeRepository gradeRepository;

    public GradeExportService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void export(UUID courseUuid, ExportFormat exportFormat, OutputStream outputStream) {
        final List<Grade> grades = gradeRepository.findGradesByCourseUuid(courseUuid);

        switch (exportFormat) {
            case CSV: {
                final List<List<String>> csvData = grades.stream()
                    .map(grade -> List.of(
                        grade.getCourseUuid().toString(),
                        grade.getGradeType().name(),
                        grade.getIssueDateTime().toString(),
                        grade.getValue().toString()
                    ))
                    .toList();

                CsvWriter.export(csvData, outputStream);
                return;
            }

            case STRING: {
                PrintStream printStream = new PrintStream(outputStream);
                grades.stream()
                    .map(ToStringGenerator::shallowToString)
                    .forEach(printStream::println);
                return;
            }

            default: {
                throw new IllegalArgumentException(exportFormat.name());
            }
        }
    }

}
