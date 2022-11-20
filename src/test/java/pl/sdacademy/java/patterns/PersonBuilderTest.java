package pl.sdacademy.java.patterns;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonBuilderTest {
    @Test
    void shouldCreatePersonWithGivenUUID(){
        Person person = new PersonBuilder()
                .uuid(UUID.fromString("52359baa-1d67-4836-9ce8-28e040b6b4fd"))
                .firstName("Jan")
                .lastName("Kowalski")
                .build();

        //then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Jan");
        assertThat(person.getLastName()).isEqualTo("Kowalski");
        assertThat(person.getUuid().toString()).isEqualTo("52359baa-1d67-4836-9ce8-28e040b6b4fd");
    }
    @Test
    void shouldCreatePersonWithRandomUuid(){
        Person person = new PersonBuilder()
                .uuid(UUID.randomUUID())
                .firstName("Jan")
                .lastName("Kowalski")
                .build();

        //then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Jan");
        assertThat(person.getLastName()).isEqualTo("Kowalski");
        assertThat(person.getUuid().toString()).isNotNull();
    }

    @Test
    void shouldCreatePersonWithNullUuid(){
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