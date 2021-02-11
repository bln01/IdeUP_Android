package org.techtown.ideup.retrofit;

import org.techtown.ideup.retrofit.dto.ProjectDto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
//    @GET("/diarys") // 챌린지목록(추천챌린지포함)
//    Call<ArrayList<Diary>> getDiarys();
//    @GET("/") // 챌린지목록(추천챌린지포함)
//    Call<String> getTest();
//    @POST("/diarys/") // 사진업로드
//    Call<Diary> postDiary(@Body Diary diary);

    @GET("/projects")
    Call<ArrayList<ProjectDto>> getProjectList(); // 프로젝트 리스트 받아오기
}
