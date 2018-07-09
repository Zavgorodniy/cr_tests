package com.zavgorodniy.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ModelListAdapter adapter;
    private ArrayList<Model> models;

    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    private void init() {
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);

        findViewById(R.id.bt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addModel();
            }
        });

        findViewById(R.id.bt_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList(MainActivity.TAG, models);
//                intent.putExtras(bundle);
                intent.putParcelableArrayListExtra(MainActivity.TAG, models);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        models = new ArrayList<>();
        RecyclerView rvModels = findViewById(R.id.rv_models);
        rvModels.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ModelListAdapter(this, models);
        rvModels.setAdapter(adapter);
    }

    private void addModel() {
        models.add(new Model(etName.getText().toString(), etAge.getText().toString()));
        adapter.notifyDataSetChanged();
    }
}
