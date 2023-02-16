package reactive.streams.flux.error;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class OnErrorResumeTest {

    @Test
    public void methodTest() {
        Flux.fromIterable(getDataFromNetwork()) // obtiene datos desde la red
                .map(this::processData) // procesa los datos
                .onErrorResume(e -> {
                    // maneja el error de red
                    System.out.println("Error de red: " + e.getMessage());
                    // retorna un flujo de elementos alternativos o un flujo vacío en caso de error
                    return Flux.empty();
                })
                .subscribe(
                        data -> System.out.println("Datos procesados: " + data),
                        error -> System.out.println("Error al procesar datos: " + error.getMessage())
                );
    }

    private String processData(String input) {
        return "Prefijo_" + input;
    }

    private List<String> getDataFromNetwork() {
        // Simula la obtención de datos desde la red
        boolean hasError = true;
        if (hasError) {
            throw new RuntimeException("Error de red");
        } else {
            return Arrays.asList("dato1", "dato2", "dato3");
        }
    }



}
