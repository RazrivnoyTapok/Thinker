package com.example.thinker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.PopupMenu;

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

        ImageButton btn_menu = findViewById(R.id.button_menu);
        btn_menu.setOnClickListener(this::showMenu);

        int marginInDp = 10;
        int marginInPx = dpToPx(marginInDp);

        Knowledge banana = new Knowledge("banana", "banana desc", Knowledge.TYPE_BANANA);
        Knowledge apple = new Knowledge("apple", "apple desc", Knowledge.TYPE_APPLE);

        ArrayList<Knowledge> data = new ArrayList<>(List.of(banana, apple));
        KnowledgeAdapter adapter = new KnowledgeAdapter(data);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new CardItemDecoration(marginInPx));
    }

    private void showMenu(android.view.View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_list_activity, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.item_menu_la_add) {
                Intent intent = new Intent(ListActivity.this, AddKnowledgeActivity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.item_menu_la_lib) {
                Intent intent = new Intent(ListActivity.this, LibraryActivity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.item_menu_la_set) {
                Intent intent = new Intent(ListActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.item_menu_la_exp) {
                Intent intent = new Intent(ListActivity.this, ExportActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
        popupMenu.show();
    }

    public int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}