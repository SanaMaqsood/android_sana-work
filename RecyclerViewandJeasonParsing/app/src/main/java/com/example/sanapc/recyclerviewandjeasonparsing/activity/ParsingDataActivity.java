package com.example.sanapc.recyclerviewandjeasonparsing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sanapc.recyclerviewandjeasonparsing.R;
import com.example.sanapc.recyclerviewandjeasonparsing.dto.HospitalActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.example.sanapc.recyclerviewandjeasonparsing.dto.HospitalActivity.Rooms;
import static com.example.sanapc.recyclerviewandjeasonparsing.dto.HospitalActivity.Swipper;
import static com.example.sanapc.recyclerviewandjeasonparsing.dto.HospitalActivity.doctors;

/**
 * Created by Sana PC on 7/26/2017.
 */

public class ParsingDataActivity extends AppCompatActivity {
    String id, Hname, email, contact, longitude, latitude, city, country;
    HospitalActivity hospital = new HospitalActivity();

    private final String jason = "{\"code\":\"200\",\"message\":\"Successful\",\"hospitals\":[{\"id\":\"1\",\"name\":\"1Ali Hospital\",\"email\":\"ali@gmail.com\",\"contact\":\"0333 1234567\",\"longitude\":\"7.91111\",\"latitude\":\"5.1455\",\"city\":\"lahore\",\"country\":\"Pakistan\",\"timeStamp\":\"2017-07-13 16:02:39\",\"staff\":{\"doctors\":[{\"doc_name\":\"misbah\"},{\"doc_name\":\"misbah\"},{\"doc_name\":\"misbah\"}],\"sweeper\":[{\"name\":\"xyz\"},{\"name\":\"xyz\"},{\"name\":\"xyz\"}]},\"rooms\":[{\"name\":\"room1\"},{\"name\":\"room1\"},{\"name\":\"room1\"}]}]}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parsing_hospital_activity);

        try {
            JSONObject jsonObject = new JSONObject(jason);
            JSONArray hospitalActivity = jsonObject.getJSONArray("hospitals");
            for (int i = 0; i < hospitalActivity.length(); i++) {
                JSONObject c = hospitalActivity.getJSONObject(i);
                id = c.getString("id");
                Hname = c.getString("name");
                email = c.getString("email");
                contact = c.getString("contact");
                longitude = c.getString("longitude");
                latitude = c.getString("latitude");
                city = c.getString("city");
                country = c.getString("country");
                hospital.setId(Integer.valueOf(id));
                hospital.setName(Hname);
                hospital.setEmail(email);
                hospital.setContact(contact);
                hospital.setLongitude(Double.valueOf(longitude));
                hospital.setLatitude(Double.valueOf(latitude));
                hospital.setCity(city);
                hospital.setCountry(country);
                JSONObject staff = c.getJSONObject("staff");

                JSONArray doctors = staff.getJSONArray("doctors");
                for (int j = 0; j < doctors.length(); j++) {
                    JSONObject stafdoctr = doctors.getJSONObject(j);
                    String doc_name = stafdoctr.getString("doc_name");
                    (hospital.getStaff()).getDoctorses().add(new doctors(doc_name));
                }
//                doctors.getJSONArray(doc_name);
                JSONArray sweepers = staff.getJSONArray("sweeper");
                for (int j = 0; j < sweepers.length(); j++) {
                    JSONObject stafswepper = sweepers.getJSONObject(j);
                    String name = stafswepper.getString("name");
                    hospital.getStaff().getSwippers().add(new Swipper(name));
                }

                JSONArray rooms = c.getJSONArray("rooms");
                for (int k = 0; k < rooms.length(); k++) {
                    JSONObject roomss = rooms.getJSONObject(k);
                    String name = roomss.getString("name");
                    hospital.getRoomses().add(new Rooms(name));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
