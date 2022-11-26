package pl.sdacademy.java.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractCsvLoader<T> implements DataLoader<T> {
    private final Supplier<InputStream> inputStreamSupplier;

    public AbstractCsvLoader(Supplier<InputStream> inputStreamSupplier) {
        this.inputStreamSupplier = inputStreamSupplier;
    }

    public List<T> loadData() {

        try(BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(
                inputStreamSupplier.get()
            )
        )){
            return bufferedReader.lines()
                .map(line -> line.split(","))
                .map(this::parseLine)
                .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract T parseLine(String[] fields);
}
