package org.techtown.ideup.retrofit.dto;

import com.google.gson.annotations.SerializedName;

public class ProjectDto {

    @SerializedName("id")
    private Long id; // 프로젝트 아이디

    @SerializedName("teamName")
    private String teamName; // 창업팀 이름

    @SerializedName("projectName")
    private String projectName; // 프로젝트명

    @SerializedName("projectContent")
    private String projectContent; // 프로젝트 내용

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }
}
