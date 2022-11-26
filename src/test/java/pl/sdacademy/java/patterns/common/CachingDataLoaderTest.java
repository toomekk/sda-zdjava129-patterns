package pl.sdacademy.java.patterns.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CachingDataLoaderTest {

    @Mock
    private DataLoader<String> mockDataLoader;

    @Test
    void shouldLoadDataOnce() {
        //given
        given(mockDataLoader.loadData()).willReturn(List.of("foo"));

        CachingDataLoader<String> cachingDataLoader = new CachingDataLoader<>(mockDataLoader);

        //when
        List<String> data1 = cachingDataLoader.loadData();
        List<String> data2 = cachingDataLoader.loadData();

        //then
        assertThat(data1).containsExactly("foo");
        assertThat(data2).containsExactly("foo");

        verify(mockDataLoader, times(1)).loadData();
    }
}
