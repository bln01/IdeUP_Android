package org.techtown.ideup.ProjectList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.ideup.R;
import org.techtown.ideup.retrofit.dto.ProjectDto;
import org.techtown.ideup.retrofit.serviceImpl.ProjectServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectListFragment extends Fragment {

    private final ProjectServiceImpl projectService;

    public ProjectListFragment(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_project_list, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.projectListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<ProjectDto> projectList = new ArrayList<>();
        try {
            projectList = projectService.getProjectList();
            System.out.println(projectList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProjectListAdapter adapter = new ProjectListAdapter();

        for(ProjectDto project : projectList){
            adapter.addItem(project);
        }
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
