package com.padcmyanmar.asartaline_app_assignment_pkk.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paikhantko on 7/7/18.
 */

public class TasteVO {

    @SerializedName("tasteId")
    private String tasteId;

    @SerializedName("taste")
    private String taste;

    @SerializedName("tasteDesc")
    private String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }
}
