package reactive.streams.flux;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Comparator;

public class FluxSortTest {

    @Test
    public void methodTest() {
        // Crear un flujo de números enteros desordenados
        Flux<Integer> numeros = Flux.just(4, 2, 1, 5, 3);

        // Utilizar el método "sort" para ordenar los números enteros en orden ascendente
        Flux<Integer> numerosOrdenados = numeros.sort();

        // Imprimir los números enteros ordenados
        numerosOrdenados.subscribe(System.out::println);

        // Utilizar el método "sort" para ordenar los números enteros en orden descendente
        Flux<Integer> numerosOrdenadosDescendente = numeros.sort(Comparator.reverseOrder());

        // Imprimir los números enteros ordenados en orden descendente
        numerosOrdenadosDescendente.subscribe(System.out::println);
    }

}
