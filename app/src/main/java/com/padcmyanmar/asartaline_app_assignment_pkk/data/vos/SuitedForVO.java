package com.padcmyanmar.asartaline_app_assignment_pkk.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paikhantko on 7/7/18.
 */

public class SuitedForVO {
    @SerializedName("suitedForId")
    private String suitedForId;

    @SerializedName("suitedFor")
    private String suitedFor;

    @SerializedName("suitedForDesc")
    private String suitedForDesc;

    public String getSuitedForId() {
        return suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }
}
