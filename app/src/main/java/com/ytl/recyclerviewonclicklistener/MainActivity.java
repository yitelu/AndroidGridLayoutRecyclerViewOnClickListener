package com.ytl.recyclerviewonclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements greenAdapter.itemClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_layout);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(OrientationHelper.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);

        greenAdapter adapter = new greenAdapter(200, this);


        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int itemIndex) {
        Toast.makeText(this, "clicked: "+itemIndex, Toast.LENGTH_SHORT).show();
    }
}
