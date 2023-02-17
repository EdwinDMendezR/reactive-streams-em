package reactive.streams;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RestController
public class MultiplesSolicitudesSimultaneasRestController {


    @GetMapping("/process")
    public Supplier<CompletableFuture<String>> prin() {
        return () -> {
            return CompletableFuture.completedFuture("********");
        };
    }


    @GetMapping
    public ParallelFlux<String> getMessage() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("Element " + state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                });
        return flux.parallel();
    }


    @GetMapping("/opcion")
    public ParallelFlux<Integer> getMessageInteger() {
        return Flux.range(1, 100000)
                .parallel() // Habilita el procesamiento en paralelo
                .filter(this::isPrime) // Filtra los números primos
                .runOn(Schedulers.parallel());
    }


    private Flux<String> getArrays() {
        Flux<String> stringFlux = Flux.just("Hola Mundo", "Java 9");
        return null;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
