package com.example.sanapc.recyclerviewandjeasonparsing.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sanapc.recyclerviewandjeasonparsing.R;
import com.example.sanapc.recyclerviewandjeasonparsing.adapter.RVAdapter;
import com.example.sanapc.recyclerviewandjeasonparsing.dto.DataHospital;
import com.example.sanapc.recyclerviewandjeasonparsing.dto.HospitalItems;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   Context context;
    private final String json = "{\"code\":\"200\",\"message\":\"Successful\",\"hospitals\":[{\"id\":\"1\",\"name\":\"1Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"},{\"id\":\"2\",\"name\":\"2Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"},{\"id\":\"3\",\"name\":\"3Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"},{\"id\":\"4\",\"name\":\"4Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"},{\"id\":\"5\",\"name\":\"5Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"},{\"id\":\"6\",\"name\":\"6Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\"}]}";
    ArrayList<HospitalItems> hospitalList = new ArrayList<>();
    private DataHospital mData = new DataHospital();
    RecyclerView rvhospital;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvhospital=(RecyclerView) findViewById(R.id.rv_hospital);
        mLayoutManager = new LinearLayoutManager(this);
        rvhospital.setLayoutManager(mLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray hospitals = jsonObject.getJSONArray("hospitals");
//            int code = jsonObject.getInt("code");
//            String Message = jsonObject.getString("message");

            for (int i = 0; i < hospitals.length(); i++) {
                JSONObject c = hospitals.getJSONObject(Integer.valueOf(i));
                String id = c.getString("id");
                String name = c.getString("name");
                String email = c.getString("email");
                String contact = c.getString("contact");
                String longitude = c.getString("longitude");
                String latitude = c.getString("latitude");
                String city = c.getString("city");
                String country = c.getString("country");
                String timeStamp = c.getString("timeStamp");


                HospitalItems hospitalItem = new HospitalItems(Integer.valueOf(id), name, email, contact, Double.valueOf(longitude), Double.valueOf(latitude), city, country, timeStamp);
                hospitalList.add(hospitalItem);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        mData = new Gson().fromJson(json, DataHospital.class);
        RVAdapter rvAdapter=new RVAdapter(this,mData);
        rvhospital.setAdapter(rvAdapter);
        Toast.makeText(this, "sexy parsing is done", Toast.LENGTH_LONG).show();

    }

}
