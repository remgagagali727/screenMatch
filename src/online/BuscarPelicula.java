package online;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BuscarPelicula {

    private String keyRute = "src/online/apikey.key";
    private String url = "https://www.omdbapi.com/";
    private HttpClient client;
    private HttpResponse response;
    private HttpRequest request;
    private String key;

    public BuscarPelicula() {
        this.client = HttpClient.newHttpClient()    ;
        try {
            this.key = new String(Files.readAllBytes(Paths.get(keyRute)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String buscarPelicula(String nombre) throws IOException, InterruptedException {
        String url = this.url + "?" + "t=" + nombre + "&" + "apikey=" + key;
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body().toString();
    }

}
