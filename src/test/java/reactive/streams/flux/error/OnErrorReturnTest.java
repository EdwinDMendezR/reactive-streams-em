package reactive.streams.flux.error;

import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class OnErrorReturnTest {

    @Test
    public void methodTest() {

        Flux<Integer> flux = Flux.range(1, 10)
                .flatMap(i -> {
                    // Hacer una petición de red
                    return WebClient.create().get()
                            .uri("https://api.example.com/data/" + i)
                            .retrieve()
                            .bodyToMono(Integer.class)
                            .onErrorReturn(-1);
                });

        flux.subscribe(
                value -> System.out.println(value),
                error -> System.err.println("*************** ".concat(error.getMessage())),
                () -> System.out.println("Flujo completo.")
        );


    }

}
