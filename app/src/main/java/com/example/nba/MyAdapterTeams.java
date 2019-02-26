package com.example.nba;

import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.nba.model.Teams;

public class MyAdapterTeams extends RecyclerView.Adapter<MyAdapterTeams.ViewHolder> {
    private List<Teams> values;

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

    public MyAdapterTeams(List<Teams> myDataset) {
        values = myDataset;
    }

    @Override
    public MyAdapterTeams.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Teams selectedTeams = values.get(position);
        final String name = selectedTeams.getName();
        final String full_name = selectedTeams.getFull_name();
        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Full Name  : " + full_name);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
