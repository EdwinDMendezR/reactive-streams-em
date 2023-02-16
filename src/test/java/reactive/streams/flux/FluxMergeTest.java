package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxMergeTest {

    @Test
    public void methodTest() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6);
        Flux<Integer> mergedFlux = Flux.merge(flux1, flux2);
        mergedFlux.subscribe(System.out::println);
    }

}
