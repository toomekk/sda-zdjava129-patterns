package pl.sdacademy.java.patterns.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.java.patterns.common.CachingDataLoader;
import pl.sdacademy.java.patterns.grade.infrastructure.DataLoaderGradeRepository;
import pl.sdacademy.java.patterns.grade.infrastructure.GradeCsvLoader;
import pl.sdacademy.java.patterns.grade.domain.GradeRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CourseFinalGradeServiceIntegrationTest {

    @Mock
    private CourseRepository courseRepository;

    private CourseFinalGradeService courseFinalGradeService;

    @BeforeEach
    void setUp() {
        GradeRepository gradeRepository = new DataLoaderGradeRepository(
            new CachingDataLoader<>(
                new GradeCsvLoader(
                    ()->CourseFinalGradeServiceIntegrationTest.class
                        .getResourceAsStream("/grades.csv")
                )
            )
        );

        courseFinalGradeService = new CourseFinalGradeService(
            gradeRepository,
            courseRepository
        );
    }

    @Test
    void shouldCalculateFinalGrade() {
        //given
        UUID courseUuid = UUID.fromString("E85966EA-A3B8-42CB-8DF3-0C2E92EFBDAF");

        given(courseRepository.findByCourseUuid(courseUuid))
        .willReturn(Optional.of(new Course(
            courseUuid,
            null,
            null,
            AverageGradingStrategy.getInstance()
        )));

        //when
        final Optional<BigDecimal> result = courseFinalGradeService.calculateFinalGradeByCourseUuid(courseUuid);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualByComparingTo("3.5");
    }
}
