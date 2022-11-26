package pl.sdacademy.java.patterns.course;

import pl.sdacademy.java.patterns.grade.domain.Grade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface GradingStrategy {
    Optional<BigDecimal> calculateFinalGrade(List<Grade> grades);
}
