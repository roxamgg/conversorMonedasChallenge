package com.alura.convertidormonedas.metodos;
import com.alura.convertidormonedas.modelos.Moneda;
import com.alura.convertidormonedas.modelos.ResultadoConversor;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class ConversorAPI {

    public Moneda consulta(Moneda moneda, double amount){

        try{
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6d646d5f4316be81741932f6/pair/" + moneda.getBaseCurrencyCode() + "/" + moneda.getTargetCurrencyCode() + "/" + amount);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Se utiliza clase record para interpretar Json.
            ResultadoConversor miResultadoConversor = UtilidadGson.getGson().fromJson(response.body(), ResultadoConversor.class);

            //Se retorna información.
            return new Moneda(miResultadoConversor, amount, LocalDateTime.now());
        }
        catch(Exception e){
            throw new RuntimeException("No se encontró esa opción.");
        }
    }
}
