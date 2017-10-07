package com.example.sanapc.studentdatamanagment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class StudentInputActivity extends AppCompatActivity {

    private Button btSubmit;
    private EditText etName, etRollNo, etCNIC;

    public String sName, sRollNo, sCNic;

    public static final String NAME = "name";
    public static final String ROLL_NO = "rollNo";
    public static final String CNiC = "cNic";

//    ArrayList<String> list = new ArrayList<String>();
//    List<String> mList = new ArrayList<String>();
//    Map<String, String> mMap= new HashMap<>();
    String[] arrayName = new String[5];
    int i = 0;

    List<Student> mStudentList = new ArrayList<>();

    Student mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_input); // set the layout in activity

        initViews();
        initOnClickListeners();

        // 1) clear data
        // 2) delete 2nd value
        // 3) explore functions

    }

    private void initViews() {
        btSubmit = (Button) findViewById(R.id.bt_send);
        etName = (EditText) findViewById(R.id.Name);
        etRollNo = (EditText) findViewById(R.id.RNo);
        etCNIC = (EditText) findViewById(R.id.cNic);
    }

    private void initOnClickListeners() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = etName.getText().toString();
                sRollNo = etRollNo.getText().toString();
                sCNic = etCNIC.getText().toString();
//                mStudent = new Student(sName, sRollNo, sCNic);

                arrayName[i] = etName.getText().toString();
                arrayName[i] = etRollNo.getText().toString();
                arrayName[i] = etCNIC.getText().toString();
                i++;


                mStudentList.add(mStudent);

//                list.add(sName);
//                mList.add(sName);
//                mMap.put(sName,sName);


                // Intent myIntent = new Intent(getBaseContext(), StudentInformation.class);
                // myIntent.putExtra(NAME, sName);
                // myIntent.putExtra(ROLL_NO,sRollNo);
                // myIntent.putExtra(CNIC, sCNic);
                // startActivity(myIntent);

//                saveData();
//                Intent sd = new Intent(StudentInputActivity.this, StudentInformation.class);
//                startActivity(sd);
//                Toast.makeText(StudentInputActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveData() {
        if (sName.length() > 0 && sRollNo.length() > 0 && sCNic.length() > 0) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(NAME, sName);
            editor.putString(ROLL_NO, sRollNo);
            editor.putString(CNiC, sCNic);
            editor.commit();
        }
    }
}


