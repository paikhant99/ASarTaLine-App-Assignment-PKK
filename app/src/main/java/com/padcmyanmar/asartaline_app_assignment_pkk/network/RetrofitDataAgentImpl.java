package com.padcmyanmar.asartaline_app_assignment_pkk.network;

import com.padcmyanmar.asartaline_app_assignment_pkk.events.ApiErrorEvent;
import com.padcmyanmar.asartaline_app_assignment_pkk.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline_app_assignment_pkk.network.responses.WarDeeResponse;
import com.padcmyanmar.asartaline_app_assignment_pkk.utils.ASarTalineConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paikhantko on 7/7/18.
 */

public class RetrofitDataAgentImpl implements WarDeeDataAgent {

    private ASarTaLineApi theApi;
    private static RetrofitDataAgentImpl mObjInstance;

    private RetrofitDataAgentImpl() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ASarTalineConstants.ASATALINE_BASED_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        theApi=retrofit.create(ASarTaLineApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(mObjInstance==null){
            mObjInstance=new RetrofitDataAgentImpl();
        }
        return mObjInstance;
    }


    @Override
    public void loadWardeeList(String accessToken) {
        final Call<WarDeeResponse> warDeeResponseCall=theApi.loadWarDeeList(accessToken);
        warDeeResponseCall.enqueue(new Callback<WarDeeResponse>() {
            @Override
            public void onResponse(Call<WarDeeResponse> call, Response<WarDeeResponse> response) {
                WarDeeResponse warDeeResponse=response.body();
                if(warDeeResponse!=null){
                    SuccessGetWarDeeEvent successGetWarDeeEvent=new SuccessGetWarDeeEvent(warDeeResponse.getWarDees());
                    EventBus.getDefault().post(successGetWarDeeEvent);
                }else{
                    ApiErrorEvent errorEvent=new ApiErrorEvent(warDeeResponse.getMessage());
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<WarDeeResponse> call, Throwable t) {
                ApiErrorEvent errorEvent=new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
