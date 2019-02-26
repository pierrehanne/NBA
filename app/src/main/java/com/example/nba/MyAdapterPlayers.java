package com.example.nba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nba.model.Players;

import java.util.List;

public class MyAdapterPlayers extends RecyclerView.Adapter<MyAdapterPlayers.ViewHolder>  {
    private List<Players> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
        }
    }

    public MyAdapterPlayers(List<Players> myDataset) {
        values = myDataset;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Players selectedPlayers = values.get(position);
        final String firstName = selectedPlayers.getFirst_name();
        final String post = selectedPlayers.getPosition();
        holder.txtHeader.setText(firstName);
        holder.txtFooter.setText("Position : " + post);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
