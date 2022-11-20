package pl.sdacademy.java.patterns;

import java.util.UUID;

class Person {
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person(UUID uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

}
