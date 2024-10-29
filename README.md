# Conversor de monedas

## Descripción

Este es un conversor de monedas simple que permite a los usuarios convertir entre diferentes divisas. El aplicativo guarda un historial de conversiones en un archivo JSON y utiliza una API externa para obtener las tasas de cambio.

## Funcionalidades

- **Conversión de monedas**: Convierte entre Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).
- **Historial de conversiones**: Guarda y muestra un historial de todas las conversiones realizadas.
- **Interfaz de línea de Comandos**: Interactúa con el usuario a través de una interfaz de línea de comandos.

## Cómo utilizarlo

1. **Compila y ejecuta el proyecto**:
   - Asegúrate de tener Java instalado en la máquina.
   - Compila el proyecto y ejecuta la clase principal `ConversorAPP`.

2. **Selecciona una opción**:
   - Al iniciar, se te presentará un menú con opciones para convertir monedas o ver el historial.
   - Ingresa el número correspondiente a la opción deseada.

3. **Realiza la conversión**:
   - Si seleccionas una opción de conversión, se solicitará que ingreses la cantidad que deseas convertir.
   - El resultado se mostrará en la consola y se guardará en un archivo llamado `conversiones.json`.

4. **Ver historial**:
   - Selecciona la opción para ver el historial de conversiones y se mostrará en la consola.
  
## Imágenes

Para más detalles sobre el uso del aplicativo, consulta las imágenes en la carpeta `imagenes` de este proyecto.

## GSON

Carpeta que tiene el archivo .jar de GSON. Es necesario para la ejecución del proyecto.
Se agrega en: file/archivo --> project structure/estructura proyecto --> modules/modulos.

## Estructura del Proyecto
com.alura.convertidormonedas 

1. principal 
   - ConversorAPP.java //Clase principal que ejecuta la aplicación.
2. metodos 
   - ConversorAPI.java //Trabaja las solicitudes a la API de conversión de moneda. 
   - ConversorLocalDateTime.java //Serializa y deserializa objetos LocalDateTime. 
   - UtilidadFile.java //Trabaja la lectura y escritura de archivos JSON. 
   - UtilidadGson.java //Configura Gson para el manejo de JSON. 
3. modelos 
   - Moneda.java //Representa la información de una conversión de moneda. 
   - ResultadoConversor.java //Almacena el resultado de la conversión desde la API.
     
imagenes 
- menu.png 
- conversor.png 
- resultado.png

GSON
- gson-2.11.0.jar

## Funcionamiento de las clases

- **ConversorAPP**: 
  - Clase principal que contiene el método `main`. Muestra un menú al usuario y gestiona la lógica para seleccionar la opción de conversión o ver el historial. Cierra el recurso de `Scanner` al finalizar.

- **Moneda**: 
  - Representa los detalles de una conversión, como las divisas base y objetivo, el monto a convertir, el resultado de la conversión y la fecha/hora de la consulta. Contiene métodos para realizar conversiones y       mostrar información.

- **ResultadoConversor**: 
  - Clase de tipo `record` que almacena el resultado de la conversión obtenido de la API, incluyendo los códigos de moneda base y objetivo y el resultado de la conversión.

- **ConversorAPI**: 
  - Maneja las solicitudes HTTP a la API de tasas de cambio. Realiza una consulta basada en las divisas y el monto, y devuelve un objeto `Moneda` con el resultado.

- **ConversorLocalDateTime**: 
  - Implementa `JsonSerializer` y `JsonDeserializer` para convertir objetos `LocalDateTime` a y desde su representación en JSON, utilizando un formato específico.

- **UtilidadFile**: 
  - Contiene métodos para leer y escribir datos en un archivo JSON. Guarda resultados de conversiones y recupera el historial de conversiones.

- **UtilidadGson**: 
  - Configura y proporciona una instancia de `Gson` personalizada, registrando un adaptador para manejar objetos `LocalDateTime`.

## Ejemplo de Uso

Al iniciar el programa, se mostrará lo siguiente:

******************************************
Bienvenido/a al conversor de monedas

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Histórico de consultas
8) Salir
Elija una opción válida:
******************************************

Después de seleccionar una opción y realizar una conversión, el resultado se mostrará de la siguiente manera:
El valor 25.0[USD] corresponde al valor final de =>> 24720.75[ARS]. Día y hora de consulta: 2024/10/29 10:24

## Notas

- Asegúrate de que el archivo `conversiones.json` sea accesible y tenga permisos de escritura.
- Este aplicativo utiliza una API externa para obtener tasas de cambio. Asegúrate de que tu conexión a internet esté activa.

