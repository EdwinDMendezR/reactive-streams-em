package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxWindowTest {

    @Test
    public void methodTest() {
        Flux.range(1, 10)
                .window(3) // dividir el flujo en ventanas de tamaño 3
                .flatMap(window -> window.collectList()) // convertir cada ventana en una lista de elementos
                .subscribe(System.out::println); // imprimir cada lista resultante
    }

}
