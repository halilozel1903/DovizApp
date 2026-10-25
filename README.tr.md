# DovizApp

[English](README.md) · [Español](README.es.md)

DovizApp, güncel döviz kurlarını tek ekranda gösteren bir Android uygulamasıdır. Yazdığınız bir tutarı çevirmez. **Kurları göster** düğmesine bastığınızda güncel kurları indirir ve listeyi doldurur. Kurları yenilemek için ağ bağlantısı gerekir.

Rakamlar [Fixer](https://fixer.io/) güncel kur servisinden gelir. Bu kaynak euroyu baz alır; her değer **1 EUR** karşılığıdır.

## Kurlar

| Kod | Para birimi | Satırın anlamı |
| --- | --- | --- |
| CAD | Kanada doları | 1 euro karşılığı Kanada doları |
| GBP | İngiliz sterlini | 1 euro karşılığı sterlin |
| EUR | Euro | Baz birim; değer 1'dir |
| KWD | Kuveyt dinarı | 1 euro karşılığı dinar |
| TRY | Türk lirası | 1 euro karşılığı lira |

İlk başarılı yenilemeye kadar satırlarda yalnız para kodu görünür. Ardından ikinci ekran görüntüsündeki örnek gibi `TRY : 17.479888` biçimini alırlar.

## Ekran görüntüleri

İki görüntü de depoda hazırdır:

<img src="app/src/main/res/drawable/screen_1.png" width="200" alt="Kurlar yüklenmeden önce DovizApp" /> <img src="app/src/main/res/drawable/screen_2.png" width="200" alt="Kurlar yüklendikten sonra DovizApp; euro satırı 1" />

`screen_1.png` yenilemeden önceki ekrandır. `screen_2.png` kurlar yüklendikten sonraki aynı ekrandır; euro satırı `EUR : 1` okunur. Bu çekimlerde düğme hâlâ eski **GÖSTER** yazısını taşır ve ilk görüntüde üçüncü satır **USD** yer tutucusudur. Güncel ekran o satırı **EUR**, düğmeyi ise **Kurları göster** olarak yazar.

## Derleme gereksinimleri

`master` dalındaki mevcut araç zinciriyle derleyin:

- Android Gradle Plugin **9.4.1**
- Gradle **9.8.1** (sürüm wrapper ile sabitlenmiştir)
- `compileSdk` **37** ve `targetSdk` **37**
- `minSdk` **24**
- JDK **17** veya daha yenisi (JDK 21 ile doğrulandı)
- Android Studio Rabbit 1 (2026.2.1) veya daha yenisi
- Android SDK Platform 37 ve Android SDK Build-Tools 36.0.0 veya daha yenisi

## Derleme

Proje kökünde wrapper, Gradle 9.8.1 sürümünü seçer:

```bash
./gradlew assembleDebug
```

Hata ayıklama APK dosyası `app/build/outputs/apk/debug/app-debug.apk` yoluna yazılır.

Bu derlemeyi bağlı bir cihaza veya çalışan bir öykünücüye (API 24 ya da üzeri) kurmak için:

```bash
./gradlew installDebug
```

Windows'ta `./gradlew` yerine `gradlew.bat` çalıştırın. Projeyi Android Studio'da açıp `app` yapılandırmasını da çalıştırabilirsiniz.

## Destek

Proje işinize yaradıysa yazara bir kahve ısmarlayabilirsiniz:

[![Buy Me A Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/halilozel1903)

## Lisans

DovizApp, MIT Lisansı ile yayınlanır. Copyright (c) 2022 Halil OZEL.

Aşağıdaki metin İngilizce MIT Lisansıdır.

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
