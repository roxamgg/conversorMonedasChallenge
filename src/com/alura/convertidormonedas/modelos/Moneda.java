package com.alura.convertidormonedas.modelos;
import com.alura.convertidormonedas.metodos.UtilidadFile;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Moneda {
    private String baseCurrencyCode;
    private String targetCurrencyCode;
    private double amount;
    private double conversionResult;
    private LocalDateTime fechaHoraConsulta;
    private static String archivo = "conversiones.json";

    public Moneda(){

    }

    public Moneda(ResultadoConversor miResultadoConversor, double amount, LocalDateTime fechaHora) {
        this.baseCurrencyCode = miResultadoConversor.base_code();
        this.targetCurrencyCode = miResultadoConversor.target_code();
        this.conversionResult = miResultadoConversor.conversion_result();
        this.amount = amount;
        this.fechaHoraConsulta = fechaHora;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public void conversion(int opcion) throws IOException {
        switch(opcion){
            case 1:
                this.setBaseCurrencyCode("USD");
                this.setTargetCurrencyCode("ARS");
                break;
            case 2:
                this.setBaseCurrencyCode("ARS");
                this.setTargetCurrencyCode("USD");
                break;
            case 3:
                this.setBaseCurrencyCode("USD");
                this.setTargetCurrencyCode("BRL");
                break;
            case 4:
                this.setBaseCurrencyCode("BRL");
                this.setTargetCurrencyCode("USD");
                break;
            case 5:
                this.setBaseCurrencyCode("USD");
                this.setTargetCurrencyCode("COP");
                break;
            case 6:
                this.setBaseCurrencyCode("COP");
                this.setTargetCurrencyCode("USD");
                break;
            case 7:
                File file = new File(archivo);
                if (!file.exists()) {
                    System.out.println("No existe un histórico de consultas. Es necesario ingresar datos para mostrar la información.");
                    return; //Sale del metodo si el archivo no existe.
                }
                //Si existe se lee la información del archivo.
                List<Moneda> monedas = UtilidadFile.leerArchivo(archivo);
                for (Moneda moneda : monedas) {
                    System.out.println(moneda);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "El valor " + amount + "[" + baseCurrencyCode + "]" +
                "corresponde al valor final de =>> " + conversionResult +
                "[" + targetCurrencyCode + "]. Día y hora de consulta: " + fechaHoraConsulta;
    }

}
