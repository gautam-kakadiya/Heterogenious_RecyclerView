package com.example.sysadmin.heterogeniousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView parentRecyclerView;
    private RecyclerView.LayoutManager linearLayout;
    private RViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Object> list = new ArrayList<>();
        list.add(new MyItem1("Gautam Kakadiya","Java team"));
        list.add(new MyItem1("Akshay Singh","phpteam"));
        list.add(new MyItem1("Udit Kansal","Java team"));
        list.add(new MyItem1("Shwetank","Java team"));
        list.add("Image");
        list.add(new MyItem1("Vaibhav Gupta","Java team"));
        list.add(new MyItem1("Akshay Kumar","php team"));

        adapter = new RViewAdapter(this,list);
        parentRecyclerView = (RecyclerView) findViewById(R.id.parentRecyclerView);
        linearLayout = new LinearLayoutManager(this);
        parentRecyclerView.setLayoutManager(linearLayout);
        parentRecyclerView.setAdapter(adapter);
    }
}
