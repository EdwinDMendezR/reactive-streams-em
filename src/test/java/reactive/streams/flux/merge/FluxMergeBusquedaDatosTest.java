package reactive.streams.flux.merge;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FluxMergeBusquedaDatosTest {

    @Setter
    @Getter
    class Product {
        private String producto;
        private Double price;

        public Product(String producto, double price) {
            setProducto(producto);
            setPrice(price);
        }
    }

    @Test
    public void methodTest() {

        Flux<Product> productFlux1 = readFromSQLDatabase();
        Flux<Product> productFlux2 = readFromNoSQLDatabase();
        Flux<Product> mergedProductFlux = Flux.merge(productFlux1, productFlux2);

        mergedProductFlux
                .distinct()
                .sort(Comparator.comparing(Product::getPrice))
                .subscribe(product -> System.out.println(product.producto));


    }

    private Flux<Product> readFromNoSQLDatabase() {
        List<Product> list = Arrays.asList(
                new Product("Productoa", 20.0),
                new Product("Productob", 21.0)
        );
        return Flux.fromIterable(list);
    }

    private Flux<Product> readFromSQLDatabase() {
        List<Product> list = Arrays.asList(
                new Product("Productoc", 19.0),
                new Product("Productod", 28.0)
        );
        return Flux.fromIterable(list);
    }

}
