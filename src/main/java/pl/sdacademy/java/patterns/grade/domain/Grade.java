package pl.sdacademy.java.patterns.grade.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Grade {
    private final UUID courseUuid;
    private final GradeType gradeType;
    private final BigDecimal value;
    private final LocalDateTime issueDateTime;

    public Grade(UUID courseUuid, GradeType gradeType, BigDecimal value, LocalDateTime issueDateTime) {
        this.courseUuid = courseUuid;
        this.gradeType = gradeType;
        this.value = value;
        this.issueDateTime = issueDateTime;
    }

    public UUID getCourseUuid() {
        return courseUuid;
    }

    public GradeType getGradeType() {
        return gradeType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }
}
