package com.example.numad21fa_tianyulu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<LinkUnit> linkUnitList;
    private ClickListener ClickListener;

    public ViewAdapter(ArrayList<LinkUnit> linkUnitList) {

        this.linkUnitList = linkUnitList;
    }

    public void setOnLinkClickListener(ClickListener ClickListener) {
        this.ClickListener = ClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_items, parent, false);
        return new ViewHolder(view, ClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder linkCollectorViewHolder, int position) {
        LinkUnit currentLinkItem = linkUnitList.get(position);
        linkCollectorViewHolder.linkName.setText(currentLinkItem.getLinkName());
        linkCollectorViewHolder.linkUrl.setText(currentLinkItem.getLinkUrl());
    }

    @Override
    public int getItemCount() {
        return linkUnitList.size();
    }


    public interface ClickListener {
        void onLinkClick(int position);
    }

}
