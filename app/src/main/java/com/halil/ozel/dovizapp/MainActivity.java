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

    TextView tryTextView, cadTextView, eurTextView, gbpTextView, kwdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tryTextView = findViewById(R.id.tryTxt);
        cadTextView = findViewById(R.id.cadTxt);
        eurTextView = findViewById(R.id.eurTxt);
        gbpTextView = findViewById(R.id.gbpTxt);
        kwdTextView = findViewById(R.id.kwdTxt);
    }


    public void verileriGetir(View view) {

        DownloadData downloadData = new DownloadData();

        try {

            // URL the exchange rates are loaded from.
            String url = "http://data.fixer.io/api/latest?access_key=7bfc13a3771f6828fa015c76be8fa59d&format=1";

            downloadData.execute(url); // Fetch the data at this URL.

        } catch (Exception ignored) {

        }
    }

    /* AsyncTask can update the UI. Its callbacks publish the result of background
    work on the UI thread. It is intended for short operations.
    */

    @SuppressLint("StaticFieldLeak")
    public class DownloadData extends AsyncTask<String, Void, String> {

        /*
        doInBackground runs work that must not block the UI.
        Return a value here to pass it to onPostExecute.
         */

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder(); // Holds the downloaded text.
            URL url;
            HttpURLConnection httpURLConnection;

            try {

                /*
                 Java I/O uses streams. A stream is a sequence of data.
                 Streams can read from many sources, such as disk, a database, or the console.
                 */

                url = new URL(strings[0]); // Use the first URL argument.
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                // InputStream: the program reads data from an external source.


                // OutputStream: the program writes data to an external source.

                int data = inputStreamReader.read();

                while (data > 0) {

                    char character = (char) data;
                    result.append(character); // Append each character to the result.

                    data = inputStreamReader.read();


                }

                return result.toString(); // Return the text when the read succeeds.

            } catch (Exception e) {

                return null; // Return nothing when the read fails.

            }


        }


        /*
        onPostExecute receives the value returned by doInBackground on the main thread.
        It can update the UI.
         */

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // System.out.println("Received data: " + s);

            try {

                JSONObject jsonObject = new JSONObject(s);
                String rates = jsonObject.getString("rates");


                JSONObject jsonObject1 = new JSONObject(rates);
                String TRY = jsonObject1.getString("TRY");
                String eur = jsonObject1.getString("EUR");
                String CAD = jsonObject1.getString("CAD");
                String KWD = jsonObject1.getString("KWD");
                String GBP = jsonObject1.getString("GBP");


                tryTextView.setText(getString(R.string.rate_try, TRY));
                eurTextView.setText(getString(R.string.rate_eur, eur));
                cadTextView.setText(getString(R.string.rate_cad, CAD));
                kwdTextView.setText(getString(R.string.rate_kwd, KWD));
                gbpTextView.setText(getString(R.string.rate_gbp, GBP));


            } catch (Exception ignored) {

            }

        }
    }
}
