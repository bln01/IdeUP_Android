package org.techtown.ideup.retrofit.dto;

import com.google.gson.annotations.SerializedName;

public class ComplainDto {

    @SerializedName("id")
    private Long id; // 프로젝트 아이디

    @SerializedName("writer")
    private WriterDto writer;

    @SerializedName("complain_content")
    private String complainContent; // 불편글 내용

    public Long getId() {
        return id;
    }

    public WriterDto getWriter() {
        return writer;
    }

    public String getComplainContent() {
        return complainContent;
    }
}
