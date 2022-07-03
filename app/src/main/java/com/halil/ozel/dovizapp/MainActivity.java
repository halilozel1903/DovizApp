package com.halil.ozel.dovizapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tryTextView, cadTextView, usdTextView, gbpTextView, kwdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tryTextView = findViewById(R.id.tryTxt);
        cadTextView = findViewById(R.id.cadTxt);
        usdTextView = findViewById(R.id.usdTxt);
        gbpTextView = findViewById(R.id.gbpTxt);
        kwdTextView = findViewById(R.id.kwdTxt);
    }


    public void verileriGetir(View view) {

        DownloadData downloadData = new DownloadData();

        try {

            // değerleri çekeceğimiz url
            String url = "http://data.fixer.io/api/latest?access_key=7bfc13a3771f6828fa015c76be8fa59d&format=1";

            downloadData.execute(url); // url deki verileri getir.

        } catch (Exception ignored) {

        }
    }

    /* AsyncTask : Kullanıcı arayüzünde işlemler yapılabilir. Bu sınıfla gelen metodlar ile arka
    planda yapılan bir işlemin sonuçları UI thread ile arayüzde gösterilir.
    Özellikle kısa süren işlemleri yapmak için kullanılır.
    */

    @SuppressLint("StaticFieldLeak")
    public class DownloadData extends AsyncTask<String, Void, String> {

        /*
        doInBackground : Kullanıcı arayüzünü etkilemeden arkaplan da yapılmak istenen işlemler burada
        yapılır. Burada yapılan işlemler bittikten sonra arayüze bir mesaj vs göndermek istenirse, mesajı
        bu metotda bulunan return koduyla birlikte onPostExecute metoduna gönderebilirsiniz.
         */

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder(); // download edilen değerleri koyma işlemi
            URL url;
            HttpURLConnection httpURLConnection;

            try {

                /*
                 Java da tüm input/output işlemleri stream üzerinden yapılır .
                 Stream ; sıralı olarak işlemler yapılan veri dizisidir .
                 Stream çok farklı veri kaynaklarından veri alışverişi yapabilir ; disk , veritabanı , console vb.
                 */

                url = new URL(strings[0]); // strings dizinin 0.index'teki değerini al ve url'e ata.
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                // Input Stream : Java programı dış kaynaktan(veri tabanı ,disk) veri okurken  kullanır


                // Output Stream : Java  programından dış kaynağa (veri tabanı , disk) veri gönderilirken kullanılır

                int data = inputStreamReader.read();

                while (data > 0) {

                    char character = (char) data;
                    result.append(character); // dataları result'a kaydettik.

                    data = inputStreamReader.read();


                }

                return result.toString(); // hata yoksa değeri döndür.

            } catch (Exception e) {

                return null; // hata varsa hiçbir şey döndürme

            }


        }


        /*
        onPostExecute : doInBackground() metodu bittikten sonra uygulamanın ana iş
        parçasına bir mesaj göndermek istediğinizde gelen mesaj bu metot ile alınır.
        Uygulamanın ana akışını etkiler hataya kesinlikle sebep olmaz.
         */

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // System.out.println("Alınan data : "+s);

            try {

                JSONObject jsonObject = new JSONObject(s);
                String rates = jsonObject.getString("rates");


                JSONObject jsonObject1 = new JSONObject(rates);
                String TRY = jsonObject1.getString("TRY");
                String USD = jsonObject1.getString("EUR");
                String CAD = jsonObject1.getString("CAD");
                String KWD = jsonObject1.getString("KWD");
                String GBP = jsonObject1.getString("GBP");


                tryTextView.setText("TRY : " + TRY);
                usdTextView.setText("EUR : " + USD);
                cadTextView.setText("CAD : " + CAD);
                kwdTextView.setText("KWD : " + KWD);
                gbpTextView.setText("GBP : " + GBP);


            } catch (Exception ignored) {

            }

        }
    }
}
