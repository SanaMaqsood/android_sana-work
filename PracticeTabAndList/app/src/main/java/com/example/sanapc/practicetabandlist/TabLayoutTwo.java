package com.example.sanapc.practicetabandlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/25/2017.
 */

public class TabLayoutTwo extends Fragment {
    private ListView list;
    private ArrayList<Students> myList = new ArrayList<>();

    public static final String KEY_PASS = "pass";
    ListViewAdaptar adaptar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tablayouttwo, container, false);
        list = (ListView) v.findViewById(R.id.list_view);
        setFetchData();
        setAdaptar();
        return v;
    }

    private void setFetchData() {
        try {
//            if (getActivity() != null && getActivity().getIntent() != null) {
//                if ((ArrayList<Students>) getActivity().getIntent().getSerializableExtra(KEY_PASS) != null)
//                    myList = (ArrayList<Students>) getActivity().getIntent().getSerializableExtra(KEY_PASS);
//            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setAdaptar() {
        try {
            adaptar = new ListViewAdaptar(getActivity().getApplicationContext(), myList);
            list.setAdapter(adaptar);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void resetAdapter(ArrayList<Students> myList) {
        adaptar = new ListViewAdaptar(getActivity().getApplicationContext(), myList);
        list.setAdapter(adaptar);
    }

    public void setList(ListView list) {
        this.list = list;
    }
}
