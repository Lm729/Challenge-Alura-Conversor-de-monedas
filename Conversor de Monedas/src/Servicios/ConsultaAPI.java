package Servicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private static final String API_KEY = "Tu API KEY";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    public String obtenerTasas(String monedaBase, String target, double monto) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String direccion = URL_BASE + API_KEY + "/pair/" + monedaBase + "/" + target + "/" + monto;

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
        catch (Exception e) {
            throw new RuntimeException("Error al conectar al Servidor" + e.getMessage());
        }
    }
}
