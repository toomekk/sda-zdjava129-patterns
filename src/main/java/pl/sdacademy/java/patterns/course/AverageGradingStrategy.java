package pl.sdacademy.java.patterns.course;

import pl.sdacademy.java.patterns.grade.Grade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

// singleton example
public class AverageGradingStrategy implements GradingStrategy {
    private static final AverageGradingStrategy instance = new AverageGradingStrategy();

    public static GradingStrategy getInstance() {
        return instance;
    }

    private AverageGradingStrategy() {}

    @Override
    public Optional<BigDecimal> calculateFinalGrade(List<Grade> grades) {
        return calculateAverage(grades);
    }

    public static Optional<BigDecimal> calculateAverage(List<Grade> grades) {
        final Optional<BigDecimal> sum = grades.stream()
            .map(Grade::getValue)
            .reduce(BigDecimal::add);

        final BigDecimal divisor = BigDecimal.valueOf(grades.size());

        return sum.map(v -> v.divide(divisor, 2, RoundingMode.CEILING));
    }
}
