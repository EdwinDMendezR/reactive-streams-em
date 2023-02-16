package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxMapTest {

    @Test
    public void methodTest() {

        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5); // crear un flujo de números enteros

        Flux<Integer> squaredNumbers = numbers.map(n -> n * n); // aplicar la operación map para elevar cada número al cuadrado

        squaredNumbers.subscribe(System.out::println);

    }

}
