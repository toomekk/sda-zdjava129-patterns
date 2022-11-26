package pl.sdacademy.java.patterns.grade;

import java.util.List;
import java.util.UUID;

public interface GradeRepository {
    List<Grade> findGradesByCourseUuid(UUID courseUuid);
}
