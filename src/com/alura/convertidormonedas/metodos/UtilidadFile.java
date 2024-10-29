package com.alura.convertidormonedas.metodos;
import com.alura.convertidormonedas.modelos.Moneda;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilidadFile {

    public static void guardarResultado(Moneda result, String archivo) throws IOException {

        //Se obtiene información del archivo.
        List<Moneda> conversiones = leerArchivo(archivo);

        //Se agrega la nueva información.
        conversiones.add(result);

        //Se agrega la información al archivo.
        try (FileWriter escritura = new FileWriter(archivo)) {
            escritura.write(UtilidadGson.getGson().toJson(conversiones));
        }
    }

    public static List<Moneda> leerArchivo(String archivo) throws IOException {
        File file = new File(archivo);
        List<Moneda> conversiones = new ArrayList<>();

        //Se obtiene la información existente.
        if (file.exists()) {
            String contenido = leerContenidoArchivo(file);
            if (!contenido.isEmpty()) {
                //Si existe información, se llena la lista.
                conversiones = UtilidadGson.getGson().fromJson(contenido, new TypeToken<List<Moneda>>(){}.getType());
            }
        }

        return conversiones;
    }

    private static String leerContenidoArchivo(File file) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lectura = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = lectura.readLine()) != null) {
                contenido.append(line);
            }
        }
        return contenido.toString();
    }

}
