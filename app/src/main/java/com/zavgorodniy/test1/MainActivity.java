package com.zavgorodniy.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "tag";
    private RecyclerView rvModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        findViewById(R.id.bt_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, SecondActivity.class), 1000);
            }
        });

        rvModels = findViewById(R.id.rv_models);
        rvModels.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) return;

        ArrayList<Model> models = data.getParcelableArrayListExtra(TAG);
        ModelListAdapter adapter = new ModelListAdapter(this, models);
        rvModels.setAdapter(adapter);
    }
}
