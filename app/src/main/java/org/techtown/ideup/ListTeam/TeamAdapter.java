package org.techtown.ideup.ListTeam;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.ideup.InfoTeam.infoTeamActivity;
import org.techtown.ideup.R;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> implements OnTeamItemClickListener{
    ArrayList<Team> items = new ArrayList<Team>();
    OnTeamItemClickListener listener;

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.team_item, parent, false);

        return new TeamAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        Team item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Team item){
        items.add(item);
    }
    public void setItems(ArrayList<Team> items){
        this.items = items;
    }

    public Team getItem(int position){
        return items.get(position);
    }

    public void setOnItemClickListener(OnTeamItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tname_tV, tinfo_tV;
        ImageView team_iV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tname_tV = itemView.findViewById(R.id.tname_tV);
            tinfo_tV = itemView.findViewById(R.id.tinfo_tV);
            team_iV = itemView.findViewById(R.id.team_iV);

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(view.getContext(), infoTeamActivity.class);
                        // 서버 연결 시 넣어야할 부분!
                        view.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void setItem(Team item){
            tname_tV.setText(item.getName());
            tinfo_tV.setText(item.getInfo());
            team_iV.setImageResource(item.getImage());
        }
    }
}
