package pl.sdacademy.java.patterns.course;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Optional<Course> findByCourseUuid(UUID courseUuid);
}
