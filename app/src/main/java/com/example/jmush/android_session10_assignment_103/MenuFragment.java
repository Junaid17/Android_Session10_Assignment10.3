package com.example.jmush.android_session10_assignment_103;

/**
 * Created by jmush on 9/5/17.
 */

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFragment  extends ListFragment{
    String[] players={"JUNAID","ANIL","WASIM","PRATEEK"};
    int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher ,R.drawable.ic_launcher,R.drawable.ic_launcher };
    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //MAP
        HashMap<String, String> map=new HashMap<String, String>();
        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"Player","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.text_fragment, from, to );
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}