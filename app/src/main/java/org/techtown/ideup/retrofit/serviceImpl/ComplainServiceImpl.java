package org.techtown.ideup.retrofit.serviceImpl;

import android.util.Log;

import org.techtown.ideup.retrofit.ApiService;
import org.techtown.ideup.retrofit.RetrofitClient;
import org.techtown.ideup.retrofit.dto.ComplainDto;
import org.techtown.ideup.retrofit.dto.ResponseDto;

import java.io.IOException;
import java.util.ArrayList;

public class ComplainServiceImpl {
    private static final ApiService apiService = RetrofitClient.getApiService();
    private ArrayList<ComplainDto> complainList;
    private ResponseDto responseDto;

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

    public ResponseDto postLike(final Long projectId) throws IOException {
        System.out.println("좋아요 버튼 누름 : " + projectId);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    responseDto = apiService.postLike("temporary_token", projectId).execute().body();
                    Log.d("Response","" + responseDto.isSuccess());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();
            return responseDto;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}