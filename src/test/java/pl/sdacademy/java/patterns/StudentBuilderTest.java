package pl.sdacademy.java.patterns;

import org.junit.jupiter.api.Test;

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
