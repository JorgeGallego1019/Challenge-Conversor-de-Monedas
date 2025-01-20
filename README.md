# Conversor de Monedas

Este proyecto es una aplicación básica en Java que permite convertir valores entre diferentes monedas utilizando tasas de cambio obtenidas de una API externa. Es una excelente herramienta para aprender sobre estructuras de control, clases, paquetes y consumo de servicios REST.

## Estructura del Proyecto

El proyecto está dividido en dos paquetes principales:

### `Menu`
- **Clase `MostrarMenu`**:
  Contiene el método `mostrarMenu()` que imprime en consola las opciones disponibles para el usuario.

### `Principal`
- **Clase `ConversorMonedas`**:
  Contiene el método principal (`main`) que controla el flujo del programa. Este incluye:
  - Un menú interactivo para que el usuario seleccione las monedas a convertir.
  - Obtención de tasas de cambio utilizando la API de ExchangeRate-API.
  - Cálculo del valor convertido con base en la tasa obtenida.

## Requisitos Previos

- **Java Development Kit (JDK)**: Versión 11 o superior.
- **Conexión a Internet**: Necesaria para obtener las tasas de cambio desde la API.
- **Dependencias**:
  - Biblioteca `gson` de Google para el manejo de JSON. Asegúrate de incluirla en el proyecto (puedes usar [Maven](https://mvnrepository.com/artifact/com.google.code.gson/gson) o agregar manualmente el JAR al proyecto).
