package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FluxEventTest {

    class Componente {
        // Método que emite eventos del componente
        public void emitirEvento(int id) {
            System.out.println("Se emitió un evento con el id " + id);
        }
    }

    @Test
    public void methodTest() {
        Componente componente = new Componente();
        Flux<Integer> flujo = Flux.create(emitter -> {
            // Generar eventos del componente y emitirlos al flujo
            for (int i = 0; i < 10; i++) {
                componente.emitirEvento(i);
                emitter.next(i);
            }
            emitter.complete(); // Se completa el flujo después de emitir todos los eventos
        });

        flujo.subscribe(
                evento -> System.out.println("Se recibió un evento: " + evento),
                error -> System.err.println("Ocurrió un error: " + error),
                () -> System.out.println("El flujo se completó")
        );
    }

}
