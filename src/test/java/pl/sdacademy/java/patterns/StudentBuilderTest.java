package pl.sdacademy.java.patterns;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;


class StudentBuilderTest {
    @Test
    void shouldCreateStudent(){
        //when
        Student student = new StudentBuilder()
                .groupCode("4A")
                .person(new Person(UUID.randomUUID(),"Jan", "Kowalski"))
                .build();

        //then
        assertThat(student).isNotNull();
        assertThat(student.getGroupCode()).isEqualTo("4A");
        assertThat(student.getPerson().getFirstName()).isEqualTo("Jan");
        assertThat(student.getPerson().getLastName()).isEqualTo("Kowalski");

    }

}