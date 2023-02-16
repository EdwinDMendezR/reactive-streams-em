package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxFromTest {

    @Test
    public void methodTest() {

        // Arrange
        Flux<Integer> flujoOriginal = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // Flujo original que emite números enteros

        Flux<Integer> flujoFiltrado = flujoOriginal
                .filter(numero -> numero % 2 == 0) // Filtrar sólo los números pares
                .map(numero -> numero * 2); // Multiplicar por 2 los números pares

        flujoFiltrado.subscribe(numero -> System.out.println(numero)); // Suscribirse al flujo filtrado y mostrar los números


        // Act

        // Assert

    }

}
