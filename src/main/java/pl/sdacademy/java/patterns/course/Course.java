package pl.sdacademy.java.patterns.course;

import java.util.UUID;

public class Course {
    private final UUID uuid;

    private final UUID studentUuid;

    private final String subjectCode;

    private final GradingStrategy gradingStrategy;

    public Course(UUID uuid, UUID studentUuid, String subjectCode, GradingStrategy gradingStrategy) {
        this.uuid = uuid;
        this.studentUuid = studentUuid;
        this.subjectCode = subjectCode;
        this.gradingStrategy = gradingStrategy;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getStudentUuid() {
        return studentUuid;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public GradingStrategy getGradingStrategy() {
        return gradingStrategy;
    }
}
