package pl.sdacademy.java.patterns.grade;

import pl.sdacademy.java.patterns.common.DataLoader;

import java.util.List;
import java.util.UUID;

public class DataLoaderGradeRepository implements GradeRepository {
    private final DataLoader<Grade> gradeDataLoader;

    public DataLoaderGradeRepository(DataLoader<Grade> gradeDataLoader) {
        this.gradeDataLoader = gradeDataLoader;
    }

    @Override
    public List<Grade> findGradesByCourseUuid(UUID courseUuid) {
        return gradeDataLoader.loadData().stream()
            .filter(grade -> grade.getCourseUuid().equals(courseUuid))
            .toList();
    }
}
