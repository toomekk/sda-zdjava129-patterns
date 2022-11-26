package pl.sdacademy.java.patterns.common;

import java.util.List;

public interface DataLoader<T> {
    List<T> loadData();
}
