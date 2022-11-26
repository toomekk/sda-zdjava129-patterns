package pl.sdacademy.java.patterns.common;

import java.util.List;

//decorator example
public class CachingDataLoader<T> implements DataLoader<T> {
    private final DataLoader<T> internalDataLoader;
    private List<T> cache;

    public CachingDataLoader(DataLoader<T> internalDataLoader) {
        this.internalDataLoader = internalDataLoader;
    }

    @Override
    public List<T> loadData() {
        if (cache == null) {
            cache = internalDataLoader.loadData();
        }

        return List.copyOf(cache);
    }
}
