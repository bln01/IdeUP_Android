package org.techtown.ideup.retrofit.serviceImpl;

import org.techtown.ideup.retrofit.ApiService;
import org.techtown.ideup.retrofit.RetrofitClient;
import org.techtown.ideup.retrofit.dto.ProjectDto;
import org.techtown.ideup.retrofit.dto.TeamDto;

import java.io.IOException;
import java.util.ArrayList;

public class TeamServiceImpl {

    private static ApiService apiService = RetrofitClient.getApiService();
    public static ArrayList<TeamDto> teamList;

    public ArrayList<TeamDto> getTeamList() throws IOException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    teamList = apiService.getTeamList().execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();
            return teamList;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
