package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromIterableTest {

    @Test
    public void methodTest() {

        // Arrange
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Act
        Flux<Integer> flujoNumeros = Flux.fromIterable(numeros);

        // Assert
        flujoNumeros.subscribe(numero -> System.out.println(numero));

    }

}
