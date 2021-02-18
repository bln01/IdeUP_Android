package org.techtown.ideup.retrofit.dto;

import com.google.gson.annotations.SerializedName;

public class WriterDto {

    @SerializedName("user_id")
    private String writerId; // 작성자 아이디

    @SerializedName("user_name")
    private String userName; // 작성자 이름

}
