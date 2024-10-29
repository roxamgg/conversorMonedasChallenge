package com.alura.convertidormonedas.principal;
import com.alura.convertidormonedas.metodos.ConversorAPI;
import com.alura.convertidormonedas.metodos.UtilidadFile;
import com.alura.convertidormonedas.modelos.Moneda;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorAPP {

    private static String archivo = "conversiones.json";

    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);

        try{
            while(true) {
                mostrarMenu();

                int opcion = lectura.nextInt();

                if (opcion < 1 || opcion > 8) {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 8.");
                    continue; //Vuelve al inicio del bucle.
                } else if (opcion == 8){
                    break; //Sale del bucle.
                } else {
                    Moneda moneda = new Moneda();
                    moneda.conversion(opcion);
                    //Si la opción es diferente a 8 se solicita el valor a convertir.
                    if (opcion != 7) {
                        System.out.println("Ingrese el valor que se desea convertir:");
                        ConversorAPI conversor = new ConversorAPI();
                        Moneda result = conversor.consulta(moneda, lectura.nextDouble());
                        //Si el resultado no está vacío, se agrega en el archivo.
                        if (result != null) {
                            UtilidadFile.guardarResultado(result, archivo);
                        }
                    }
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Ocurrió un error: Deben seleccionar solo valores númericos.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lectura.close(); //Se cierra el Scanner para liberar el recurso cuando ya no se necesita.
        }
    }

    private static void mostrarMenu() {
        System.out.println("******************************************");
        System.out.println("Bienvenido/a al conversor de monedas");
        System.out.println("\n" +
                "1) Dólar =>> Peso argentino \n" +
                "2) Peso argentino =>> Dólar \n" +
                "3) Dólar =>> Real brasileño \n" +
                "4) Real brasileño =>> Dólar \n" +
                "5) Dólar =>> Peso colombiano \n" +
                "6) Peso colombiano =>> Dólar \n" +
                "7) Histórico de consultas \n" +
                "8) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("******************************************");
    }
}
