package com.example.sanapc.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.adapter.RViewAdaptar;
import com.example.sanapc.recyclerview.dto.Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana PC on 6/2/2017.
 */

public class NevigationFragmentDrawar extends Fragment {
    private RecyclerView recyclerView;
    private RViewAdaptar adaptar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.fragment_navigation_draw, container, false);
        recyclerView = (RecyclerView) row.findViewById(R.id.recyclerview);
        adaptar= new RViewAdaptar(getActivity(),getData());
        recyclerView.setAdapter(adaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return row;
    }
    public static List<Information> getData(){
        List<Information> data= new ArrayList<>();
        int[] icons={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
        String[] titles={"One","Two","Three","Four"};

        for (int i=0; i<icons.length&& i<titles.length; i++)
        {
           Information current= new Information();
            current.iconId=icons[i];
            current.title=titles[i];

            data.add(current);
        }
  return data;

    }
}
