package Principal;

import Menu.MostrarMenu;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            MostrarMenu.mostrarMenu();
            int opcion = lectura.nextInt();

            String monedaInicial = "";
            String monedaFinal = "";

            switch (opcion) {
                case 1:
                    monedaInicial = "USD";
                    monedaFinal = "ARS";
                    break;
                case 2:
                    monedaInicial = "ARS";
                    monedaFinal = "USD";
                    break;
                case 3:
                    monedaInicial = "USD";
                    monedaFinal = "BRL";
                    break;
                case 4:
                    monedaInicial = "BRL";
                    monedaFinal = "USD";
                    break;
                case 5:
                    monedaInicial = "USD";
                    monedaFinal = "COP";
                    break;
                case 6:
                    monedaInicial = "COP";
                    monedaFinal = "USD";
                    break;
                case 7:
                    continuar = false;
                    continue;
                default:
                    System.out.println("Por favor, elija una opción válida.");
                    continue;
            }

            double tasaCambio = obtenerTasaCambio(monedaInicial, monedaFinal);

            if (tasaCambio != -1) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double valorCliente = lectura.nextDouble();
                double valorConvertido = valorCliente * tasaCambio;

                System.out.println("El valor de " + valorCliente + " [" + monedaInicial + "] corresponde al valor final de =>>> "
                        + valorConvertido + " [" + monedaFinal + "]");
            } else {
                System.out.println("No se pudo obtener la tasa de cambio para " + monedaFinal);
            }

            System.out.println();
        }

        lectura.close();
    }

    private static double obtenerTasaCambio(String monedaInicial, String monedaFinal) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/6395beab94598f6adbdf6c74/latest/" + monedaInicial;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if (conversionRates != null && conversionRates.has(monedaFinal)) {
            return conversionRates.get(monedaFinal).getAsDouble();
        }

        return -1;
    }
}
