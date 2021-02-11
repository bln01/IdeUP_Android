package org.techtown.ideup.retrofit;

import org.techtown.ideup.retrofit.dto.ProjectDto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/projects")
    Call<ArrayList<ProjectDto>> getProjectList(); // 프로젝트 리스트 받아오기
}
