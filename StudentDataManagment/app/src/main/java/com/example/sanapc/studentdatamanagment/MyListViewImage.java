package com.example.sanapc.studentdatamanagment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MyListViewImage extends AppCompatActivity {
    String[] memetitles;
    String[] memedescription;
    ListView list;
    int[] images = {R.mipmap.meme1, R.mipmap.meme2, R.mipmap.meme3, R.mipmap.meme4,
            R.mipmap.meme5, R.mipmap.meme6, R.mipmap.meme7, R.mipmap.meme8, R.mipmap.meme9, R.mipmap.meme10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.mylistview_main_activity);
        Resources res = getResources();
        memetitles = res.getStringArray(R.array.Titles);
        memedescription = res.getStringArray(R.array.Description);
        list = (ListView) findViewById(R.id.list_item);

        ListAdapter adapter= new ListAdapter(this,memetitles,images,memedescription);
        list.setAdapter(adapter);
    }
    class  ListAdapter extends ArrayAdapter<String>
    {
        Context context;
        int[] images;
        String[] titles;
        String[] description;
        ListAdapter(Context c, String[] Titles,int imgs[],String[] Description)
        {
            super(c,R.layout.mylistview_activity,R.id.tview1,Titles);
            this.context=c;
            this.images=imgs;
            this.titles=Titles;
            this.description=Description;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              View row = inflater.inflate(R.layout.mylistview_activity,parent,false);
            ImageView myimageview=(ImageView) row.findViewById(R.id.imgview1);
            TextView mytitles=(TextView) row.findViewById(R.id.tview1);
            TextView myDiscription=(TextView) row.findViewById(R.id.tView2);


            myimageview.setImageResource(images[position]);
            mytitles.setText(titles[position]);
            myDiscription.setText(description[position]);



            return row;
        }
    }

}
