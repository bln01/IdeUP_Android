package org.techtown.ideup.ProjectList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.ideup.R;
import org.techtown.ideup.retrofit.dto.ProjectDto;

import java.util.ArrayList;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {
 onProjectClickListener listener;
 ArrayList<ProjectDto> projects = new ArrayList<>();

    @NonNull
    @Override
    public ProjectListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_project, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListAdapter.ViewHolder holder, int position) {
        ProjectDto project = projects.get(position);
        holder.setTextView(project);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public void addItem(ProjectDto project){
        projects.add(project);
    }

    public void setItems(ArrayList<ProjectDto> projects){ //ArrayList전체를 설정할 수 있는 함수
        this.projects = projects;
    }


    public ProjectDto getItem(int position){
        return projects.get(position);
    }

    public void setProject(int position, ProjectDto project){
        projects.set(position, project);
    }

    public void setOnItemClickListener(onProjectClickListener listener){ //아이템뷰에 onClickListener 설정하기
        this.listener=listener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView teamName;
        private TextView projectName;
        private Button sendBT;
        private Button detailBT;
        public ViewHolder(final View itemView, final onProjectClickListener listener) {
            super(itemView);

            teamName = itemView.findViewById(R.id.teamName);
            projectName = itemView.findViewById(R.id.projectName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
        public void setTextView(ProjectDto project){
            teamName.setText(project.getTeamName());
            projectName.setText(project.getProjectName());
        }


    }
}
