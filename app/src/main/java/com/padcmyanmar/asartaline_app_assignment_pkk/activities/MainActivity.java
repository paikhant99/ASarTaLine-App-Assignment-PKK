package com.padcmyanmar.asartaline_app_assignment_pkk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.asartaline_app_assignment_pkk.R;
import com.padcmyanmar.asartaline_app_assignment_pkk.adapters.WarDeeAdapter;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.models.WarDeeModel;
import com.padcmyanmar.asartaline_app_assignment_pkk.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline_app_assignment_pkk.events.SuccessGetWarDeeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WarDeeDelegate{

    @BindView(R.id.rv_wardees)
    RecyclerView rvWardees;

    private WarDeeAdapter warDeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        warDeeAdapter=new WarDeeAdapter(this);
        rvWardees.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        rvWardees.setAdapter(warDeeAdapter);

        WarDeeModel.getObjInstance().loadWarDeeList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDees(SuccessGetWarDeeEvent successGetWarDeeEvent){
        warDeeAdapter.setWarDeeList(successGetWarDeeEvent.getWarDees());
    }

    @Override
    public void tapViewDetails() {

    }

    @Override
    public void tapRating() {

    }

    @Override
    public void tapWarDees() {

    }
}
