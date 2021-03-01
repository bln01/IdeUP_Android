package org.techtown.ideup.retrofit.dto;

import com.google.gson.annotations.SerializedName;

public class TeamDto {
    @SerializedName("team_id")
    private Long teamId;

    @SerializedName("team_name")
    private String teamName;

    @SerializedName("team_info")
    private String teamInfo;

    @SerializedName("team_image_url")
    private String teamImageUrl;

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public String getTeamImageUrl() {
        return teamImageUrl;
    }
}
