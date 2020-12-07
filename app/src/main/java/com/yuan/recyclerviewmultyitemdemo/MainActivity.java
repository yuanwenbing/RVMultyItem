package com.yuan.recyclerviewmultyitemdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.yuan.multy_item.IItemVew;
import com.yuan.multy_item.MuBaseAdapter;
import com.yuan.multy_item.VH;
import com.yuan.recyclerviewmultyitemdemo.model.Data;

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
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Data data = new Data();
            data.setTitle("title" + i);
            data.setType(random.nextInt(3));
            list.add(data);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter adapter = new SimpleAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
    }

    private static class SimpleAdapter extends MuBaseAdapter<Data> {
        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            IItemVew view = com.yuan.recyclerviewmultyitemdemo.ItemViewFactory.getViewProxy(parent.getContext(), viewType);
            return new VH(view);
        }
    }

}

