package reactive.streams.flux.zip;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ZipParalleloTest {

    @Test
    public void methodTest() {
        Flux<Integer> numeros1 = Flux.range(1, 5);
        Flux<Integer> numeros2 = Flux.range(6, 5);
        numeros1
                .zipWith(numeros2, (num1, num2) -> num1 + num2)
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(System.out::println);
    }

}
