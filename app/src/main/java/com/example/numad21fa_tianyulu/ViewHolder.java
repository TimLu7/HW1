package com.example.numad21fa_tianyulu;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView Name;
    public TextView Url;

    public ViewHolder(@NonNull View itemView, final ViewAdapter.ClickListener ClickListener) {
        super(itemView);
        Name = itemView.findViewById(R.id.link_name_value_pair);
        Url = itemView.findViewById(R.id.link_url_value_pair);

        itemView.setOnClickListener(v -> {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition != RecyclerView.NO_POSITION) {
                ClickListener.onLinkClick(layoutPosition);
            }
        });
    }
}
