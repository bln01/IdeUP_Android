package org.techtown.ideup.retrofit.dto;

import com.google.gson.annotations.SerializedName;

public class ResponseDto {

    @SerializedName("success")
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

}
