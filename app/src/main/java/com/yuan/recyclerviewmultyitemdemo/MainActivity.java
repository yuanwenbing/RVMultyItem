package com.yuan.recyclerviewmultyitemdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemEvent;
import com.yuan.multy_item.IItemVew;
import com.yuan.multy_item.MuBaseAdapter;
import com.yuan.multy_item.VH;
import com.yuan.recyclerviewmultyitemdemo.model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements IItemEvent {

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
            data.setType(random.nextInt(4));
            list.add(data);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter adapter = new SimpleAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
    }

    @Override
    public <T extends IItemData> void onItemClick(int position, T data) {
        Toast.makeText(this, "position:" + position + "   type:" + ((Data) (data)).getType(), Toast.LENGTH_SHORT).show();
    }

    private static class SimpleAdapter extends MuBaseAdapter<Data> {

        public SimpleAdapter(IItemEvent itemEvent) {
            super(itemEvent);
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            IItemVew view = com.yuan.recyclerviewmultyitemdemo.ItemViewFactory.getViewProxy(parent.getContext(), viewType);
            return new VH(view);
        }
    }

}

