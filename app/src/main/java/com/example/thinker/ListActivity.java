package com.example.thinker;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(v -> finish());

        int marginInDp = 10;
        int marginInPx = dpToPx(marginInDp);

        Knowledge banana = new Knowledge("banana", "banana desc", new TextView(this), Knowledge.TYPE_BANANA);
        Knowledge apple = new Knowledge("apple", "apple desc", new TextView(this), Knowledge.TYPE_APPLE);

        ArrayList<Knowledge> data = new ArrayList<>(List.of(banana, apple));
        KnowledgeAdapter adapter = new KnowledgeAdapter(data);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new CardItemDecoration(marginInPx));
    }

    public int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}