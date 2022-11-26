package pl.sdacademy.java.patterns.person;

import java.util.UUID;

public class Person {

    private final UUID uuid;
    private final String firstName;
    private final String lastName;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public Person(UUID uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
