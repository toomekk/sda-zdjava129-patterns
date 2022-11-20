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

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

}
