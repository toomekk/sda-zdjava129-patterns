package pl.sdacademy.java.patterns.grade.domain;

import pl.sdacademy.java.patterns.grade.domain.Grade;

import java.util.List;
import java.util.UUID;

public interface GradeRepository {
    List<Grade> findGradesByCourseUuid(UUID courseUuid);
}
