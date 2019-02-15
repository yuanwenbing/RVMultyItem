package com.yuan.recyclerviewmultyitemdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        Random random = new Random();
        List<MockData> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MockData data = new MockData();
            data.setTitle("title" + i);
            data.setType(random.nextInt(3));
            list.add(data);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter adapter = new SimpleAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
    }

    private class SimpleAdapter extends RBaseAdapter<MockData> {

        public void deleteItem(int position) {

        }
    }


}

