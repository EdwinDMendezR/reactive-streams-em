package reactive.streams.flux.merge;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FluxMergeMultipleCombinacionTest {

    @Test
    public void methodTest() throws URISyntaxException {
        Flux<String> file1 = readFile("file1.log");
        Flux<String> file2 = readFile("file2.log");
        Flux<String> file3 = readFile("file3.log");
        Flux<String> combined = Flux.merge(file1, file2, file3);
        combined.subscribe(System.out::println);
    }

    private static Flux<String> readFile(String filePath) throws URISyntaxException {
        URL resource = FluxMergeMultipleCombinacionTest.class.getClassLoader().getResource(filePath);
        File resourceFile = new File(resource.toURI());
        return Flux.using(() -> Files.lines(Paths.get(resourceFile.toPath().toString())),
                Flux::fromStream,
                stream -> {
                    try {
                        stream.close();
                    } catch (Exception e) {
                        System.out.println("***** Exception e *****");
                    }
                });
    }

}
