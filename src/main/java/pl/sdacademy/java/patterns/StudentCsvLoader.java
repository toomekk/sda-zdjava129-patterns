package pl.sdacademy.java.patterns;

import java.io.InputStream;
import java.util.UUID;
import java.util.function.Supplier;

public class StudentCsvLoader extends AbstractCsvLoader<Student> {

    public StudentCsvLoader(Supplier<InputStream> inputStreamSupplier) {
        super(inputStreamSupplier);
    }

    protected Student parseLine(String[] fields){
        return Student.builder()
            .groupCode(fields[3])
            .person(Person.builder()
                .uuid(UUID.fromString(fields[0]))
                .firstName(fields[2])
                .lastName(fields[1])
                .build()
            )
            .build();
    }
}
