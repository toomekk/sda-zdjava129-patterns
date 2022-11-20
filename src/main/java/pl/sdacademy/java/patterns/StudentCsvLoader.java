package pl.sdacademy.java.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Supplier;

public class StudentCsvLoader {

    private Supplier<InputStream> inputStreamSupplier;

    public StudentCsvLoader(Supplier<InputStream> inputStreamSupplier) {
        this.inputStreamSupplier = inputStreamSupplier;
    }

    public List<Student> loadStudents (){

        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStreamSupplier.get())
        )){
           return bufferedReader.lines()
                    .map(line -> line.split(","))
                    .map(this::parseLine)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Student parseLine(String[] fields){
        throw new UnsupportedOperationException();
    }
}
