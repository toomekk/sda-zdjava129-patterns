package pl.sdacademy.java.patterns.student;

import pl.sdacademy.java.patterns.person.Person;

public class StudentBuilder {
    private Person person;
    private String groupCode;

    public StudentBuilder person(Person person) {
        this.person = person;
        return this;
    }

    public StudentBuilder groupCode(String groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public Student build() {
        return new Student(person, groupCode);
    }
}
