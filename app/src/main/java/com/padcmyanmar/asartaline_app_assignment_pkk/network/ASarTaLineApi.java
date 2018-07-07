package com.padcmyanmar.asartaline_app_assignment_pkk.network;

import com.padcmyanmar.asartaline_app_assignment_pkk.network.responses.WarDeeResponse;
import com.padcmyanmar.asartaline_app_assignment_pkk.utils.ASarTalineConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by paikhantko on 7/7/18.
 */

public interface ASarTaLineApi {

    @FormUrlEncoded
    @POST(ASarTalineConstants.GET_WAR_DEE)
    Call<WarDeeResponse> loadWarDeeList(@Field(ASarTalineConstants.PARAMS_ACCESS_TOKEN)String accessToken);
}
