package com.example.thinker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        // Back button
        ImageButton btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(v -> finish());
        // Menu
        // Menu button
        ImageButton btn_menu = findViewById(R.id.button_menu);
        btn_menu.setOnClickListener(v -> {
        });
        // Recycler
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

    public int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
    public void toSettings(MenuItem mi) {
        Intent intent = new Intent(ListActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
    public void toLibrary(MenuItem mi) {
        Intent intent = new Intent(ListActivity.this, LibraryActivity.class);
        startActivity(intent);
    }
    public void dummyMethod(MenuItem mi) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_la_add:
                dummyMethod(item);
                return true;
            case R.id.item_menu_la_set:
                toSettings(item);
                return true;
            case R.id.item_menu_la_lib:
                toLibrary(item);
                return true;
            case R.id.item_menu_la_exp:
                dummyMethod(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}