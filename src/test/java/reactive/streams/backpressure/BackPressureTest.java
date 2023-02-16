package reactive.streams.backpressure;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BackPressureTest {

    @Test
    public void methodTest() throws InterruptedException {
        // Creamos un publicador que emite un evento cada 100 ms
        Flux<Long> publisher = Flux.interval(
                //Duration.ofMillis(100),
                Duration.ofSeconds(1)
        );

        // Creamos un suscriptor que procesa un evento cada 200 ms
        Flux<Long> subscriber = publisher
                .delayElements(Duration.ofMillis(200))
                .limitRate(5); // Configuramos el backpressure para procesar solo 5 eventos por segundo

        // Nos suscribimos al suscriptor
        subscriber.subscribe(System.out::println);

        // Esperamos un minuto para que el programa no termine
        Thread.sleep(Duration.ofSeconds(60).toMillis());

    }

}
