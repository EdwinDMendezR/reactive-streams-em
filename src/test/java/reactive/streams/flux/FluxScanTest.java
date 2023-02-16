package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxScanTest {

    @Test
    public void methodTest() {
        Flux.range(1, 5)
                .scan(0, (acc, elem) -> acc + elem)
                .subscribe(System.out::println);
    }

}
