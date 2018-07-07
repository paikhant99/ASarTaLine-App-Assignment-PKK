package com.padcmyanmar.asartaline_app_assignment_pkk.data.models;

import com.padcmyanmar.asartaline_app_assignment_pkk.network.RetrofitDataAgentImpl;
import com.padcmyanmar.asartaline_app_assignment_pkk.network.WarDeeDataAgent;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeModel {

    private static WarDeeModel mObjInstance;
    private WarDeeDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN="b002c7e1a528b7cb460933fc2875e916";

    private WarDeeModel() {
        mDataAgent=RetrofitDataAgentImpl.getObjInstance();
    }

    public static WarDeeModel getObjInstance(){
        if (mObjInstance==null){
            mObjInstance=new WarDeeModel();
        }
        return mObjInstance;
    }

    public void loadWarDeeList(){
        mDataAgent.loadWardeeList(DUMMY_ACCESS_TOKEN);
    }
}
