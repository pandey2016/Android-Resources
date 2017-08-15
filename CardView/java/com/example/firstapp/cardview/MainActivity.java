package com.example.firstapp.cardview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String[] item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new RecyclerAdapter();
        recyclerView.setAdapter(adapter);


        final ArrayList<File> mysongs=findSongs(Environment.getExternalStorageDirectory());
        item = new String[mysongs.size()];
        for(int i=0;i<mysongs.size();i++){
//            toast(mysongs.get(i).getName().toString());
            item[i]= mysongs.get(i).getName().toString().replace(".mp3","");

        }
    }

    public ArrayList<File> findSongs(File root) {
        ArrayList<File> al= new ArrayList<File>();
        File[] files=root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findSongs(singleFile));

            }
            else
            {
                if(singleFile.getName().endsWith(".mp3")){
                    al.add(singleFile);

                }
            }
        }
        return al;
    }
    }

