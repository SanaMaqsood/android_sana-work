package com.example.sanapc.recyclerviewandjeasonparsing.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sanapc.recyclerviewandjeasonparsing.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sana PC on 7/27/2017.
 */

public class UrlFetchingActivity extends AppCompatActivity {
    BufferedReader reader=null;
    HttpURLConnection connection;
    Button btn_fetch;
    TextView txt_view;
    ProgressBar progress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url_fatching_activity);
        btn_fetch=(Button) findViewById(R.id.btn_fetch);
        txt_view=(TextView) findViewById(R.id.tv_Data);
        progress=(ProgressBar) findViewById(R.id.progress);

        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JASONTASK().execute("http://5tantech.com/hospital/Hospital_api/hospital_data");
            }
        });



    }
    public class JASONTASK extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                connection=(HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream=  connection.getInputStream();
                reader= new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer=new StringBuffer();
                String line="";
                while ((line= reader.readLine()) !=null){
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(connection != null){
                    connection.disconnect();}
                try {
                    if(reader !=null){
                        reader.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            txt_view.setText(result);
            progress.setVisibility(View.GONE);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

    }
}
