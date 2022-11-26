package pl.sdacademy.java.patterns.student;

import org.junit.jupiter.api.Test;
import pl.sdacademy.java.patterns.person.Person;
import pl.sdacademy.java.patterns.student.Student;

import static org.assertj.core.api.Assertions.assertThat;

class StudentBuilderTest {
    @Test
    void shouldCreateStudent() {
        // when
        Student student = Student.builder()
                .groupCode("4a")
                .person(
                    Person.builder()
                        .firstName("Jan")
                        .lastName("Kowalski")
                        .build()
                )
                .build();

        // then
        assertThat(student).isNotNull();
        assertThat(student.getGroupCode()).isEqualTo("4a");
        assertThat(student.getPerson().getFirstName()).isEqualTo("Jan");
        assertThat(student.getPerson().getLastName()).isEqualTo("Kowalski");

    }

}
