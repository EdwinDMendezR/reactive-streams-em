package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxEmptyTest {

    @Test
    public void methodTest() {

        // Arrange
        Flux<Object> flujoVacio = Flux.empty();

        flujoVacio.subscribe(
                elemento -> System.out.println("Este mensaje no se imprimirá"),
                error -> System.out.println("Este mensaje no se imprimirá"),
                () -> System.out.println("El flujo ha terminado")
        );

        // Act

        // Assert

    }

}
