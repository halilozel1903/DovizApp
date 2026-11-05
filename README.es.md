# DovizApp

[English](README.md) · [Türkçe](README.tr.md)

DovizApp es una aplicación Android que muestra los tipos de cambio más recientes en una sola pantalla. No convierte un importe que escribas. Al pulsar **Kurları göster**, descarga los tipos actuales y rellena la lista. Actualizar los tipos requiere una conexión de red.

Las cifras proceden de la API de tipos más recientes de [Fixer](https://fixer.io/). Esa fuente usa el euro como moneda base, así que cada valor es la cantidad de esa moneda equivalente a **1 EUR**.

## Tipos de cambio

| Código | Moneda | Qué significa la fila |
| --- | --- | --- |
| CAD | Dólar canadiense | Dólares canadienses por 1 euro |
| GBP | Libra esterlina | Libras por 1 euro |
| EUR | Euro | Moneda base; el valor es 1 |
| KWD | Dinar kuwaití | Dinares por 1 euro |
| TRY | Lira turca | Liras por 1 euro |

Hasta la primera actualización correcta, las filas muestran solo el código de la moneda. Después se leen como `TRY : 17.479888`, la muestra guardada en la segunda captura.

## Capturas

Las dos imágenes ya están en el repositorio:

<img src="app/src/main/res/drawable/screen_1.png" width="200" alt="DovizApp antes de cargar los tipos" /> <img src="app/src/main/res/drawable/screen_2.png" width="200" alt="DovizApp después de cargar los tipos, con el euro en 1" />

`screen_1.png` es la pantalla antes de actualizar. `screen_2.png` es la misma pantalla después de cargar los tipos, incluido `EUR : 1`. En esas capturas el botón todavía dice **GÖSTER**, y la primera imagen conserva un marcador **USD** en la tercera fila. La pantalla actual etiqueta esa fila como **EUR** y el botón como **Kurları göster**.

## Requisitos de compilación

Compila con la cadena de herramientas que ya está en `master`:

- Android Gradle Plugin **9.4.1**
- Gradle **9.8.1**, fijado por el wrapper
- `compileSdk` **37** y `targetSdk` **37**
- `minSdk` **24**
- JDK **17** o posterior (comprobado con JDK 21)
- Android Studio Rabbit 1 (2026.2.1) o posterior
- Android SDK Platform 37 y Android SDK Build-Tools 36.0.0 o posterior

## Compilación

Desde la raíz del proyecto, el wrapper selecciona Gradle 9.8.1:

```bash
./gradlew assembleDebug
```

El APK de depuración se escribe en `app/build/outputs/apk/debug/app-debug.apk`.

Para instalar esa compilación en un dispositivo conectado o en un emulador en ejecución (API 24 o superior):

```bash
./gradlew installDebug
```

En Windows, ejecuta `gradlew.bat` en lugar de `./gradlew`. También puedes abrir el proyecto en Android Studio y ejecutar la configuración `app`.

## Apoyo

Si el proyecto te resulta útil, puedes invitar al autor a un café:

[![Buy Me A Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/halilozel1903)

## Licencia

DovizApp se publica bajo la licencia MIT. Copyright (c) 2022 Halil OZEL.

El texto siguiente es la licencia MIT en inglés.

```
MIT License

Copyright (c) 2022 Halil OZEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
