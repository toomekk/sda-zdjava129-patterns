package pl.sdacademy.java.patterns;

import java.util.UUID;

class Person {

    private UUID uuid;
    private String firstName;
    private String lastName;

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
