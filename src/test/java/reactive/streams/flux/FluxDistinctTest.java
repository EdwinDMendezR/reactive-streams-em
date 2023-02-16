package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxDistinctTest {

    @Test
    public void methodTest() {
        Flux<Integer> numeros = Flux.just(1, 2, 3, 2, 1, 4, 5, 3);
        numeros
                .distinct()
                .subscribe(System.out::println);
    }

}
