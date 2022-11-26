package pl.sdacademy.java.patterns.teacher;

import pl.sdacademy.java.patterns.person.HasPerson;
import pl.sdacademy.java.patterns.person.Person;

import java.util.Set;

class Teacher implements HasPerson {

    private Person person;
    private Set<String> subjectCodes;

    @Override
    public Person getPerson() {
        return person;
    }

    public Set<String> getSubjectCodes() {
        return subjectCodes;
    }
}
