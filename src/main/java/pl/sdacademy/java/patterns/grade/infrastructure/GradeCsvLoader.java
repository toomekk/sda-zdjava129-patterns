package pl.sdacademy.java.patterns.grade.infrastructure;

import pl.sdacademy.java.patterns.common.AbstractCsvLoader;
import pl.sdacademy.java.patterns.grade.domain.Grade;
import pl.sdacademy.java.patterns.grade.domain.GradeType;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

public class GradeCsvLoader extends AbstractCsvLoader<Grade> {

    public GradeCsvLoader(Supplier<InputStream> inputStreamSupplier) {
        super(inputStreamSupplier);
    }

    protected Grade parseLine(String[] fields) {
        return new Grade(
            UUID.fromString(fields[0]),
            GradeType.valueOf(fields[1]),
            new BigDecimal(fields[3]),
            LocalDateTime.parse(fields[2])
        );
    }
}
