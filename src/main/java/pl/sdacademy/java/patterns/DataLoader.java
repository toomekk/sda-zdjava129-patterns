package pl.sdacademy.java.patterns;

import java.util.List;

public interface DataLoader<T> {
    List<T> loadData();
}
