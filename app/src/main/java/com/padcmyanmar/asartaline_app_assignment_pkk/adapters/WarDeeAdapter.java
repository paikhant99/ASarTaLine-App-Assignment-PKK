package com.padcmyanmar.asartaline_app_assignment_pkk.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.asartaline_app_assignment_pkk.R;
import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;
import com.padcmyanmar.asartaline_app_assignment_pkk.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline_app_assignment_pkk.viewholders.WarDeeViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeAdapter extends RecyclerView.Adapter<WarDeeViewHolder> {

    private List<WarDeeVO> mWarDeeList;
    private WarDeeDelegate mWarDeeDelegate;

    public WarDeeAdapter(WarDeeDelegate warDeeDelegate) {
        mWarDeeDelegate=warDeeDelegate;
        mWarDeeList=new ArrayList<>();
    }

    @NonNull
    @Override
    public WarDeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.view_holder_war_dee,parent,false);
        return new WarDeeViewHolder(view,mWarDeeDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull WarDeeViewHolder holder, int position) {
        holder.bindData(mWarDeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWarDeeList.size();
    }

    public void setWarDeeList(List<WarDeeVO> warDeeList){
        mWarDeeList=warDeeList;
        notifyDataSetChanged();
    }
}
