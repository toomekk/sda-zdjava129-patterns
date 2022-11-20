package pl.sdacademy.java.patterns;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class PersonBuilderTest {

    @Test
    void shouldCreatePersonWithGivenUuid() {
        //when
        Person person = new PersonBuilder()
            .uuid(UUID.fromString("a7c22412-234f-4639-a04d-82414ad7cc35"))
            .firstName("Jan")
            .lastName("Kowalski")
            .build();

        //then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Jan");
        assertThat(person.getLastName()).isEqualTo("Kowalski");
        assertThat(person.getUuid().toString()).isEqualTo("a7c22412-234f-4639-a04d-82414ad7cc35");
    }

    @Test
    void shouldCreatePersonWithRandomUuid() {
        //when
        Person person = new PersonBuilder()
            .firstName("Jan")
            .lastName("Kowalski")
            .build();

        //then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Jan");
        assertThat(person.getLastName()).isEqualTo("Kowalski");
        assertThat(person.getUuid()).isNotNull();
    }

    @Test
    void shouldCreatePersonWithNullUuid() {
        //when
        Person person = new PersonBuilder()
            .uuid(null)
            .firstName("Jan")
            .lastName("Kowalski")
            .build();

        //then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Jan");
        assertThat(person.getLastName()).isEqualTo("Kowalski");
        assertThat(person.getUuid()).isNull();
    }
}
