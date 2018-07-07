package com.padcmyanmar.asartaline_app_assignment_pkk.data.models;

import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;
import com.padcmyanmar.asartaline_app_assignment_pkk.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.asartaline_app_assignment_pkk.network.RetrofitDataAgentImpl;
import com.padcmyanmar.asartaline_app_assignment_pkk.network.WarDeeDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeModel {

    private static WarDeeModel mObjInstance;
    private WarDeeDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN="b002c7e1a528b7cb460933fc2875e916";
    private Map<String,WarDeeVO> warDeeVOMap;

    private WarDeeModel() {
        mDataAgent=RetrofitDataAgentImpl.getObjInstance();
        EventBus.getDefault().register(this);
        warDeeVOMap=new HashMap<>();
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

    public WarDeeVO getWarDeeById(String warDeeId){
        return warDeeVOMap.get(warDeeId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetWarDeeEvent(SuccessGetWarDeeEvent successGetWarDeeEvent){
        for(WarDeeVO warDeeVO:successGetWarDeeEvent.getWarDees()){
            warDeeVOMap.put(warDeeVO.getWarDeeId(),warDeeVO);
        }
    }
}
