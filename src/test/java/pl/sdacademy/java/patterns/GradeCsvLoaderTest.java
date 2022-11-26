package pl.sdacademy.java.patterns;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GradeCsvLoaderTest {

    @Test
    void shouldLoadGrades() {
        //given
        GradeCsvLoader gradeCsvLoader = new GradeCsvLoader(
            () -> GradeCsvLoaderTest.class.getResourceAsStream("/grades.csv")
        );

        //when
        List<Grade> grades = gradeCsvLoader.loadData();

        //then
        assertThat(grades).hasSize(6);
        assertThat(grades).extracting(Grade::getValue).containsExactly(
            new BigDecimal("5"),
            new BigDecimal("2.5"),
            new BigDecimal("3"),
            new BigDecimal("4.5"),
            new BigDecimal("3"),
            new BigDecimal("5")
        );
    }
}
