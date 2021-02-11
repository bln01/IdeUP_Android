package org.techtown.ideup.retrofit.serviceImpl;

import org.techtown.ideup.retrofit.ApiService;
import org.techtown.ideup.retrofit.RetrofitClient;
import org.techtown.ideup.retrofit.dto.ProjectDto;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectServiceImpl {

    private static ApiService apiService = RetrofitClient.getApiService();
    public static ArrayList<ProjectDto> projectList;

    public ArrayList<ProjectDto> getProjectList() throws IOException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    projectList = apiService.getProjectList().execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();
            return projectList;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
