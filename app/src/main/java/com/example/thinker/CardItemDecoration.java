package com.example.thinker;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardItemDecoration extends RecyclerView.ItemDecoration {
    private final int spaceHeight;
    public CardItemDecoration(int spaceHeight) {
        this.spaceHeight = spaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = spaceHeight;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = spaceHeight;
        }
    }
}
