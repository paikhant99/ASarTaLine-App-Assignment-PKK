package com.padcmyanmar.asartaline_app_assignment_pkk.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.asartaline_app_assignment_pkk.R;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;
import com.padcmyanmar.asartaline_app_assignment_pkk.delegates.WarDeeDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_cost)
    TextView tvCost;

    @BindView(R.id.tv_wardee_name)
    TextView tvWarDeeName;

    @BindView(R.id.tv_taste)
    TextView tvTaste;

    @BindView(R.id.iv_wardee)
    ImageView ivWardee;

    WarDeeVO mWarDee;

    public WarDeeViewHolder(View itemView, final WarDeeDelegate warDeeDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warDeeDelegate.tapWarDees(mWarDee);
            }
        });
    }

    public void bindData(WarDeeVO warDeeVO){
        mWarDee=warDeeVO;
        tvWarDeeName.setText(warDeeVO.getWarDeeName());
        tvTaste.setText(warDeeVO.getGeneralTastes().get(0).getTaste());
        tvCost.setText(tvCost.getContext().getResources().getString(R.string.cost_price,warDeeVO.getPriceRangeMin(),warDeeVO.getPriceRangeMax()));

        if(warDeeVO.getWarDeeImages().isEmpty()){
            ivWardee.setVisibility(View.GONE);
        }else{
            Glide.with(ivWardee.getContext()).load(warDeeVO.getWarDeeImages().get(0)).into(ivWardee);
        }
    }

}
