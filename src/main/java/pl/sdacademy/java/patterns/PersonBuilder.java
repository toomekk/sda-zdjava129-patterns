package pl.sdacademy.java.patterns;

import java.util.UUID;

public class PersonBuilder {
    private UUID uuid = UUID.randomUUID();
    private String firstName;
    private String lastName;

    public PersonBuilder uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person build() {
        return new Person(uuid, firstName, lastName);
    }
}
