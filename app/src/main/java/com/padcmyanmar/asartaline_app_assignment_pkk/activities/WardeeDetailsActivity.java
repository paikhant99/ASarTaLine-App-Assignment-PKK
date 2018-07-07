package com.padcmyanmar.asartaline_app_assignment_pkk.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.asartaline_app_assignment_pkk.R;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.models.WarDeeModel;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;
import com.padcmyanmar.asartaline_app_assignment_pkk.utils.ASarTalineConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WardeeDetailsActivity extends BaseActivity {

    @BindView(R.id.iv_details_wardee)
    ImageView ivDetailsWardee;

    @BindView(R.id.tv_taste_desc)
    TextView tvTasteDesc;

    @BindView(R.id.tv_details_wardee_name)
    TextView tvWardeeName;

    @BindView(R.id.tv_details_cost)
    TextView tvCost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardee_details);
        ButterKnife.bind(this,this);

        String warDeeID=getIntent().getStringExtra(ASarTalineConstants.WAR_DEE_ID);

        WarDeeVO warDee=WarDeeModel.getObjInstance().getWarDeeById(warDeeID);

        Glide.with(ivDetailsWardee.getContext()).load(warDee.getWarDeeImages().get(0)).into(ivDetailsWardee);

        tvWardeeName.setText(warDee.getWarDeeName());
        tvTasteDesc.setText(warDee.getGeneralTastes().get(0).getTasteDesc());
        tvCost.setText(String.valueOf(warDee.getPriceRangeMax()));
    }
}
