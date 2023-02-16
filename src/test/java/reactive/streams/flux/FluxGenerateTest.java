package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxGenerateTest {

    @Test
    public void methodTest() {

        // Arrange

        // Se crea un flujo de elementos de tipo String utilizando el método Flux.generate()
        Flux<String> flux = Flux.generate(
                // La función lambda inicializa el estado del generador como 0
                () -> 0,
                // La función lambda genera los elementos y actualiza el estado del generador
                (state, sink) -> {
                    // Se emite un elemento que contiene el estado actual del generador
                    sink.next("Element " + state);
                    // Si el estado es igual a 10, se emite un evento de completado
                    if (state == 10) {
                        sink.complete();
                    }
                    // Se actualiza el estado del generador sumándole 1
                    return state + 1;
                });

        // Se suscribe al flujo generado para imprimir los elementos en la consola
        flux.subscribe(System.out::println);

        // Act

        // Assert

    }

}
