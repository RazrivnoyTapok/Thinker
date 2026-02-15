package com.example.thinker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class KnowledgeActivity extends AppCompatActivity {

    private int knowledgeId;
    private String knowledgeTitle;
    private String knowledgeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_knowledge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get data from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            knowledgeId = extras.getInt("knowledge_id", -1);
            knowledgeTitle = extras.getString("knowledge_title", "");
            knowledgeDescription = extras.getString("knowledge_description", "");
        }

        // Load appropriate layout based on knowledge type
        loadDynamicLayout();
    }

    private void loadDynamicLayout() {
        FrameLayout container = findViewById(R.id.dynamic_content_container);

        if (container == null) {
            return; // Fallback if container doesn't exist
        }

        container.removeAllViews();

        // Determine which layout to load based on knowledge ID or title
        int layoutId = getLayoutForKnowledge(knowledgeId, knowledgeTitle);

        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(layoutId, container, true);

        // Populate content
        populateContent();
    }

    private int getLayoutForKnowledge(int id, String title) {
        // Return different layout IDs based on the knowledge object
        // You can use ID, title, or create a type field in Knowledge class

        if (title.equals("banana")) {
            return R.layout.knowledge_banana_layout;
        } else if (title.equals("apple")) {
            return R.layout.knowledge_apple_layout;
        } else {
            return R.layout.knowledge_default_layout; // Fallback layout
        }
    }

    private void populateContent() {
        // Set title if view exists
        TextView titleView = findViewById(R.id.knowledge_title);
        if (titleView != null) {
            titleView.setText(knowledgeTitle);
        }

        // Set description if view exists
        TextView descView = findViewById(R.id.knowledge_description);
        if (descView != null) {
            descView.setText(knowledgeDescription);
        }

        // Add any other view population logic here
    }
}