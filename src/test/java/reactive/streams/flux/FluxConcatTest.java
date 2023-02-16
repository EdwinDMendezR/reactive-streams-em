package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxConcatTest {

    @Test
    public void methodTest() {
        Flux<Integer> flujo1 = Flux.range(1, 5);
        Flux<Integer> flujo2 = Flux.range(6, 5);
        Flux<Integer> flujoConcatenado = Flux.concat(flujo1, flujo2);
        flujoConcatenado.subscribe(System.out::println);
    }

}
