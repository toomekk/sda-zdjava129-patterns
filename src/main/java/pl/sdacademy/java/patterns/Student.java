package pl.sdacademy.java.patterns;

class Student implements HasPerson {

    private Person person;
    private String groupCode;


    @Override
    public Person getPerson() {
        return person;
    }

    public String getGroupCode() {
        return groupCode;
    }
}