package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxFlatMapTest {

    @Test
    public void methodTest() {
        Flux<String> stringFlux = Flux.just("Hola Mundo", "Java 9");
        Flux<String> wordsFlux = stringFlux
                .flatMap(s -> Flux.fromArray(s.split("\\s+")));
        wordsFlux.subscribe(System.out::println);

    }

}
