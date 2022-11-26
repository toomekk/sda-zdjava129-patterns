package pl.sdacademy.java.patterns.course;

import org.junit.jupiter.api.Test;
import pl.sdacademy.java.patterns.grade.domain.Grade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class AverageGradingStrategyTest {

    @Test
    void shouldCalculateAverageGrade() {
        //given
        GradingStrategy gradingStrategy = AverageGradingStrategy.getInstance();

        //when
        final Grade grade1 = new Grade(
            null, null,
            new BigDecimal("5.0"), null
        );

        final Grade grade2 = new Grade(
            null, null,
            new BigDecimal("4.0"), null
        );

        final Grade grade3 = new Grade(
            null, null,
            new BigDecimal("2.0"), null
        );

        //when
        Optional<BigDecimal> result = gradingStrategy.calculateFinalGrade(List.of(
            grade1, grade2, grade3
        ));

        //then
        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualByComparingTo("3.67");
    }
}
