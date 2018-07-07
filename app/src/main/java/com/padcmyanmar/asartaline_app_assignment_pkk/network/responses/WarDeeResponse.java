package com.padcmyanmar.asartaline_app_assignment_pkk.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<WarDeeVO> warDees;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<WarDeeVO> getWarDees() {
        return warDees;
    }
}
