package com.yuan.recyclerviewmultyitemdemo;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.yuan.multy_item.IItemEvent;
import com.yuan.multy_item.IItemVew;
import com.yuan.multy_item.MultiBaseAdapter;
import com.yuan.multy_item.VH;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setIntrinsicHeight(10);
        shapeDrawable.setColorFilter(new LightingColorFilter(Color.WHITE, Color.WHITE));
        dividerItemDecoration.setDrawable(shapeDrawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        Random random = new Random();
        List<ItemData> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ItemData data = new ItemData();
            data.setTitle("title" + i);
            data.setType(random.nextInt(3)); // 0, 1, 2
            list.add(data);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter adapter = new SimpleAdapter(new ItemEvent());
        recyclerView.setAdapter(adapter);
        adapter.setData(list);
    }

    private static class SimpleAdapter extends MultiBaseAdapter<ItemData> {

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

