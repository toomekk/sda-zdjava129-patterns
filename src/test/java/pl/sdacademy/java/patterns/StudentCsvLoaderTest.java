package pl.sdacademy.java.patterns;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StudentCsvLoaderTest {
    @Test
    public void shouldLoadStudents(){
        //given
        StudentCsvLoader studentCsvLoader = new StudentCsvLoader(()->StudentCsvLoaderTest.class.getResourceAsStream("/students.csv"));

        //when
        List<Student> students = studentCsvLoader.loadStudents();

        //then
        assertThat(students).hasSize(2);
        assertThat(students.get(0).getGroupCode()).isEqualTo("4A");
        assertThat(students.get(0).getPerson().getUuid().toString())
            .isEqualToIgnoringCase("B2CF3A44-FB12-4764-B386-7BFD5EF2C1FC");
        assertThat(students.get(0).getPerson().getFirstName()).isEqualTo("Anna");
        assertThat(students.get(0).getPerson().getLastName()).isEqualTo("Kowalska");

        assertThat(students.get(1).getGroupCode()).isEqualTo("4A");
        assertThat(students.get(1).getPerson().getUuid().toString())
            .isEqualToIgnoringCase("89130168-5EE5-4C34-988C-1287E17C6D73");
        assertThat(students.get(1).getPerson().getFirstName()).isEqualTo("Jan");
        assertThat(students.get(1).getPerson().getLastName()).isEqualTo("Nowak");
    }

}
