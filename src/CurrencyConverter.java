import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {
    private String API_KEY;

    public CurrencyConverter (String API_KEY) {
        this.API_KEY = API_KEY;
    }

    private double conversion(String currencyToConvert, String targetToConvert, double valueToConvert) {
        try {
            JsonConverter jsonConverter = new JsonConverter();
            String address = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s".formatted(this.API_KEY, currencyToConvert,
                    targetToConvert, valueToConvert);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();
            var objResponse = jsonConverter.jsonConversion(jsonResponse);

            return objResponse.conversionResult();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void printMessage(String currencyToConvert, String currencyTarget, double amountToConvert) {
        double resultConversion = this.conversion(currencyToConvert, currencyTarget, amountToConvert);
        String textToPrint = "A conversão de %.2f %s em %s é igual a %.2f".formatted(amountToConvert, currencyToConvert, currencyTarget,
                resultConversion);

        System.out.println(textToPrint);
    }
}
