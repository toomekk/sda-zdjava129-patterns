package pl.sdacademy.java.patterns;

import java.util.Set;

class Teacher implements HasPerson {
    private Person person;
    private Set<String> subjectCodes;

    public Set<String> getSubjectCodes() {
        return subjectCodes;
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
