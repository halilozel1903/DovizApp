package com.halil.ozel.dovizapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
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

        try{

            // değerleri çekeceğimiz url
            String url = "http://data.fixer.io/api/latest?access_key=7bfc13a3771f6828fa015c76be8fa59d&format=1";

            downloadData.execute(url); // url deki verileri getir.

        }catch (Exception e){


        }
    }

    /* AsyncTask : Kullanıcı arayüzünde işlemler yapılabilir. Bu sınıfla gelen metodlar ile arka
    planda yapılan bir işlemin sonuçları UI thread ile arayüzde gösterilir.
    Özellikle kısa süren işlemleri yapmak için kullanılır.
    */

    public class DownloadData extends AsyncTask<String,Void,String>{

        /*
        doInBackground : Kullanıcı arayüzünü etkilemeden arkaplan da yapılmak istenen işlemler burada
        yapılır. Burada yapılan işlemler bittikten sonra arayüze bir mesaj vs göndermek istenirse, mesajı
        bu metotda bulunan return koduyla birlikte onPostExecute metoduna gönderebilirsiniz.
         */

        @Override
        protected String doInBackground(String... strings) {

            String result = ""; // download edilen değerleri koyma işlemi
            URL url;
            HttpURLConnection httpURLConnection;

            try{

                url = new URL(strings[0]) ; // strings dizinin 0.index'teki değerini al ve url'e ata.
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


                int data = inputStreamReader.read();

                while (data>0){

                    char character = (char) data;
                    result += character; // dataları result'a kaydettik.

                    data = inputStreamReader.read();


                }

                return result; // hata yoksa değeri döndür.

            }catch (Exception e){

                return null; // hata varsa hiçbir şey döndürme

            }


        }


        /*
        onPostExecute : doInBackground() metodu bittikten sonra uygulamanın ana iş
        parçasına bir mesaj göndermek istediğinizde gelen mesaj bu metot ile alınır.
        Uygulamanın ana akışını etkiler hataya kesinlikle sebep olmaz.
         */

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

           // System.out.println("Alınan data : "+s);

            try {

                JSONObject jsonObject = new JSONObject(s);
                //String base = jsonObject.getString("base");
                //String date = jsonObject.getString("date");
                String rates = jsonObject.getString("rates");
                //System.out.println(base);
                //System.out.println(date);


                JSONObject jsonObject1 = new JSONObject(rates);
                String TRY = jsonObject1.getString("TRY");
                String USD = jsonObject1.getString("USD");
                String CAD = jsonObject1.getString("CAD");
                String KWD = jsonObject1.getString("KWD");
                String GBP = jsonObject1.getString("GBP");


                tryTextView.setText("TRY : "+TRY);
                usdTextView.setText("USD : "+USD);
                cadTextView.setText("CAD : "+CAD);
                kwdTextView.setText("KWD : "+KWD);
                gbpTextView.setText("GBP : "+GBP);



            }catch (Exception e){

            }

        }
    }
}
