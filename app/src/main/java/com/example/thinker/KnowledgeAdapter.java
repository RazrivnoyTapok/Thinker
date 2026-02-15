package com.example.thinker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder> {
    private ArrayList<Knowledge> dataSet;

    public KnowledgeAdapter(ArrayList<Knowledge> ds) {
        this.dataSet = ds;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final ImageButton toKnowledge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.cardTitle);
            this.description = itemView.findViewById(R.id.cardDescription);
            this.toKnowledge = itemView.findViewById(R.id.cardGoToKnowledge);
        }

        public TextView getTitle() {
            return this.title;
        }

        public TextView getDescription() {
            return this.description;
        }

        public ImageButton getToKnowledge() {
            return this.toKnowledge;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_knowledge, parent, false);
        return new KnowledgeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTitle().setText(dataSet.get(position).getCardTitle());
        holder.getDescription().setText(dataSet.get(position).getCardDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
