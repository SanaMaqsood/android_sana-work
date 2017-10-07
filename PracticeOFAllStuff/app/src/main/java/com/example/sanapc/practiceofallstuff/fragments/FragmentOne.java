package com.example.sanapc.practiceofallstuff.fragments;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.adaptar.ArrayModels;
import com.example.sanapc.practiceofallstuff.adaptar.ArrayNames;
import com.example.sanapc.practiceofallstuff.db.SQLiteCarItemsDb;
import com.example.sanapc.practiceofallstuff.dob.CarItems;
import com.example.sanapc.practiceofallstuff.dob.ItemModels;
import com.example.sanapc.practiceofallstuff.dob.ItemName;
import com.example.sanapc.practiceofallstuff.interfaces.RefreshItems;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Sana PC on 7/17/2017.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {
    private View view;
    Spinner itemNames, itemModels;
    EditText etYear, edReg;
    ImageView img;
    Button btnsubmit, btnshow;
    String name, model, year;
    String regNo;
    ArrayList<ItemName> mListItemName = new ArrayList<ItemName>();
    ArrayList<ItemModels> mlistItemModels = new ArrayList<ItemModels>();

    ArrayList<CarItems> myitems = new ArrayList<>();
    private RefreshItems mRefreshItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fregment_one, container, false);
        initDummyData();
        fetchData();
        initView();
        btnsubmit.setOnClickListener(this);
        btnshow.setOnClickListener(this);
        return view;
    }

    private void initView() {
        itemNames = (Spinner) view.findViewById(R.id.sName);
        ArrayNames myNameAdapter = new ArrayNames(getActivity(), R.layout.spinner_name_items, R.id.tvname, mListItemName);
        itemNames.setAdapter(myNameAdapter);
        itemModels = (Spinner) view.findViewById(R.id.sModel);
        ArrayModels myModelAdapter = new ArrayModels(getActivity(), R.layout.spinner_model_items, R.id.tvmodel, mlistItemModels);
        itemModels.setAdapter(myModelAdapter);
        etYear = (EditText) view.findViewById(R.id.edtDate);
        final ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        etYear.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(month) + "-" + String.valueOf(year));
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));


                datePickerDialog.show();
            }
        });
        edReg = (EditText) view.findViewById(R.id.et_reg);
        btnsubmit = (Button) view.findViewById(R.id.btn_submit);
        btnshow = (Button) view.findViewById(R.id.btn_show);
    }

    private void initDummyData() {
        mListItemName.add(0, new ItemName("Honda"));
        mListItemName.add(1, new ItemName("Suzuki"));
        mListItemName.add(2, new ItemName("Centro"));
        mListItemName.add(3, new ItemName("Landcrozer"));
        mListItemName.add(4, new ItemName("City"));
        mlistItemModels.add(0, new ItemModels("Honda"));
        mlistItemModels.add(1, new ItemModels("Suzuki"));
        mlistItemModels.add(2, new ItemModels("Centro"));
        mlistItemModels.add(3, new ItemModels("Landcrozer"));
        mlistItemModels.add(4, new ItemModels("City"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                name = ((ItemName) itemNames.getSelectedItem()).getName();

                model = ((ItemModels) itemModels.getSelectedItem()).getModel();

                year = etYear.getText().toString();
                regNo = edReg.getText().toString();

                CarItems mCar = new CarItems(myitems.size() + 1, name, model, year, regNo);
                myitems.add(mCar);

                SQLiteCarItemsDb dbHelper = new SQLiteCarItemsDb(getActivity());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(SQLiteCarItemsDb.ID, mCar.getId());
                values.put(SQLiteCarItemsDb.NAME, mCar.getName());
                values.put(SQLiteCarItemsDb.MODEL, mCar.getModel());
                values.put(SQLiteCarItemsDb.YEAR, mCar.getYear());
                values.put(SQLiteCarItemsDb.REG_NO, mCar.getRegNo());
                db.insert(SQLiteCarItemsDb.TABLE_NAME, null, values);
                break;
            case R.id.btn_show:
                mRefreshItems.refresh();
                break;

        }
    }

    private void fetchData() {
        CarItems carItems;

        SQLiteCarItemsDb dbHelper = new SQLiteCarItemsDb(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(SQLiteCarItemsDb.TABLE_NAME, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            carItems = new CarItems(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            myitems.add(carItems);
            while (c.moveToNext()) {
                carItems = new CarItems(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                myitems.add(carItems);
            }
        };
    }

    public void setmRefreshItems(RefreshItems mRefreshItems) {
        this.mRefreshItems = mRefreshItems;
    }
}
