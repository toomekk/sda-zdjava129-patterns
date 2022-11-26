package pl.sdacademy.java.patterns.grade.domain;

import org.junit.jupiter.api.Test;
import pl.sdacademy.java.patterns.grade.infrastructure.CsvGradesExporter;
import pl.sdacademy.java.patterns.grade.infrastructure.DataLoaderGradeRepository;
import pl.sdacademy.java.patterns.grade.infrastructure.GradeCsvLoader;
import pl.sdacademy.java.patterns.grade.infrastructure.StringGradesExporter;

import java.util.List;
import java.util.UUID;

class GradeExportServiceTest {

    //not a real test - should use mocks
    @Test
    void shouldExport() {
        //given
        GradeExportService gradeExportService = new GradeExportService(
            new DataLoaderGradeRepository(
                new GradeCsvLoader(()->GradeExportServiceTest.class.getResourceAsStream("/grades.csv"))
            ),
            List.of(
                CsvGradesExporter.getInstance(),
                StringGradesExporter.getInstance()
            )
        );

        //when
        gradeExportService.export(
            UUID.fromString("E85966EA-A3B8-42CB-8DF3-0C2E92EFBDAF"),
            ExportFormat.CSV,
            System.out
        );
    }
}
