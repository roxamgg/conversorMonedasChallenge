package com.alura.convertidormonedas.metodos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;

public class UtilidadGson {

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new ConversorLocalDateTime())
            .setPrettyPrinting()
            .create();

    public static Gson getGson() {
        return gson;
    }
}
