package org.techtown.ideup.retrofit.serviceImpl;

import org.techtown.ideup.retrofit.ApiService;
import org.techtown.ideup.retrofit.RetrofitClient;
import org.techtown.ideup.retrofit.dto.ComplainDto;
import org.techtown.ideup.retrofit.dto.ProjectDto;

import java.io.IOException;
import java.util.ArrayList;

public class ComplainServiceImpl {
    private static ApiService apiService = RetrofitClient.getApiService();
    public static ArrayList<ComplainDto> complainList;

    public ArrayList<ComplainDto> getComplainList() throws IOException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    complainList = apiService.getComplainList().execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();
            return complainList;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}