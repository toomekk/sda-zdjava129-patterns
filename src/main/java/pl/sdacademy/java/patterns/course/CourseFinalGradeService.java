package pl.sdacademy.java.patterns.course;

import pl.sdacademy.java.patterns.grade.Grade;
import pl.sdacademy.java.patterns.grade.GradeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseFinalGradeService {
    private final GradeRepository gradeRepository;
    private final CourseRepository courseRepository;

    public CourseFinalGradeService(GradeRepository gradeRepository, CourseRepository courseRepository) {
        this.gradeRepository = gradeRepository;
        this.courseRepository = courseRepository;
    }

    public Optional<BigDecimal> calculateFinalGradeByCourseUuid(UUID courseUuid) {
        List<Grade> courseGrades = gradeRepository.findGradesByCourseUuid(courseUuid);

        return courseRepository.findByCourseUuid(courseUuid)
            .map(Course::getGradingStrategy)
            .flatMap(strategy -> strategy.calculateFinalGrade(courseGrades));
    }
}
