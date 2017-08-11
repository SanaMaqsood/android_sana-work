package com.example.sanapc.practiceofallstuff.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.adaptar.CarItemAdaptar;
import com.example.sanapc.practiceofallstuff.db.SQLiteCarItemsDb;
import com.example.sanapc.practiceofallstuff.dob.CarItems;
import com.example.sanapc.practiceofallstuff.interfaces.RefreshItems;

import java.util.ArrayList;

/**
 * Created by Sana PC on 7/17/2017.
 */

public class FragmentTwo extends Fragment {
    private View view;

    RecyclerView rvCarItems;

    SQLiteCarItemsDb dbHelper;
    CarItemAdaptar adapter;

    public RefreshItems getRefresh() {
        return refresh;
    }

    RefreshItems refresh;
    ArrayList<CarItems> myitems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        initViews();
        setDataToRecyclerView(fetchData());
        return view;
    }

    private void initViews() {
        rvCarItems = (RecyclerView) view.findViewById(R.id.recycler1);
        rvCarItems.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<CarItems> fetchData() {
        CarItems carItems;

        dbHelper = new SQLiteCarItemsDb(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query(SQLiteCarItemsDb.TABLE_NAME, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            carItems = new CarItems(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            myitems.add(carItems);
            while (c.moveToNext()) {
                carItems = new CarItems(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                myitems.add(carItems);
            }
        }
        return myitems;
    }

    public void setDataToRecyclerView(ArrayList<CarItems> carItems) {
        adapter = new CarItemAdaptar(getActivity(), carItems, dbHelper);
        rvCarItems.setAdapter(adapter);
    }

}
