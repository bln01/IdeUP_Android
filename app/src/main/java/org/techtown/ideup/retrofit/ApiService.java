package org.techtown.ideup.retrofit;

import org.techtown.ideup.retrofit.dto.ComplainDto;
import org.techtown.ideup.retrofit.dto.ProjectDto;
import org.techtown.ideup.retrofit.dto.ResponseDto;
import org.techtown.ideup.retrofit.dto.TeamDto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/projects")
    Call<ArrayList<ProjectDto>> getProjectList(); // 프로젝트 리스트 받아오기

    @GET("/complains")
    Call<ArrayList<ComplainDto>> getComplainList(); // 불편글 리스트 받아오기

    @GET("/teams")
    Call<ArrayList<TeamDto>> getTeamList(); // 창업팀 리스트 받아오기

    @POST("/project/{projectId}/like") // 좋아요 기능 // token : 사용자 인증용
    Call<ResponseDto> postLike(@Header("Authorization") String token, @Path("projectId") Long projectId);



}
