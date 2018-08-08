package com.athos.recyclerviewwithheader.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.athos.recyclerviewwithheader.Model.ModelDados;
import com.athos.recyclerviewwithheader.R;

import java.util.List;

import static com.athos.recyclerviewwithheader.Model.ModelDeserializeDados.FILHO;
import static com.athos.recyclerviewwithheader.Model.ModelDeserializeDados.PAI;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ModelDados> mList;

    public RecyclerAdapter(List<ModelDados> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case PAI:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_body, parent, false);
                return new PaiViewHolder(view);
            case FILHO:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ModelDados object = mList.get(position);
        if (object != null) {
            switch (object.getType()) {
                case PAI:
                    ((PaiViewHolder) holder).mTitle.setText(object.getName());
                    break;
                case FILHO:
                    ((EventViewHolder) holder).mTitle.setText(object.getName());
                    ((EventViewHolder) holder).mDescription.setText(object.getDescription());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            ModelDados object = mList.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }

    public static class PaiViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public PaiViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.titleTextView);
        }
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;

        public EventViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.titleTextView);
            mDescription = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}