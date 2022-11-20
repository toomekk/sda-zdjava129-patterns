package pl.sdacademy.java.patterns;

class Student implements HasPerson {

    private Person person;
    private String groupCode;

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public Student(Person person, String groupCode) {
        this.person = person;
        this.groupCode = groupCode;

    }


    @Override
    public Person getPerson() {
        return person;
    }

    public String getGroupCode() {
        return groupCode;


    }

}
