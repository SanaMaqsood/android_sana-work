package com.example.sanapc.recyclerview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanapc.recyclerview.dto.Information;
import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.adapter.FragmentRecyclerviewAdaptar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana PC on 6/8/2017.
 */

public class Fragment_BroadcastThree extends Fragment {
    Context context;
    View v;
    RecyclerView recyclerView;
    FragmentRecyclerviewAdaptar fragmentRecyclerviewAdaptar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View row= inflater.inflate(R.layout.fragment_broadcast_three,container,false);
        v=row;
        initViews(row);
        setApadter();
        return row;
    }
  public static List<Information> getData(){
      List<Information> data=new ArrayList<>();
      int[] icons={R.drawable.one,R.drawable.two, R.drawable.three,R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.four};
      String[] titles={"One","Two","Three","Four","Four","Four","Four","Four","Four"};


      for (int i=0; i< icons.length && i < titles.length ;i++){
          Information current= new Information();
          current.iconId=icons[i];
          current.title=titles[i];
          data.add(current);


      }
      return  data;


  }
    private void setApadter() {
        fragmentRecyclerviewAdaptar= new FragmentRecyclerviewAdaptar(getContext(),getData());
        recyclerView.setAdapter(fragmentRecyclerviewAdaptar);
    }

    private void initViews(View v) {
        recyclerView=(RecyclerView) v.findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
