package reactive.streams.flux.error;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ErrorProcessingTest {

    @Test
    public void methodTest() {

        Flux<Integer> numeros = Flux.just(1, 2, 3, -4, 5);

        numeros.map(numero -> {
            if (numero < 0) {
                throw new ArithmeticException("No se puede calcular la raíz cuadrada de números negativos.");
            }
            return Math.sqrt(numero);
        }).onErrorResume(error -> {
            if (error instanceof ArithmeticException) {
                return Flux.empty(); // Devuelve un flujo vacío para continuar emitiendo elementos
            } else {
                return Flux.error(error); // Devuelve el error original si es de otro tipo
            }
        }).subscribe(System.out::println);


    }

}
