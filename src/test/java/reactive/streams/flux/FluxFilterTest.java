package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxFilterTest {

    @Test
    public void methodTest() {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);
        evenNumbers.subscribe(System.out::println);
    }

}
