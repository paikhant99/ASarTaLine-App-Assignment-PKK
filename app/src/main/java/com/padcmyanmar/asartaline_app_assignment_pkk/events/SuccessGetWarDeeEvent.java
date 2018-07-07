package com.padcmyanmar.asartaline_app_assignment_pkk.events;

import com.padcmyanmar.asartaline_app_assignment_pkk.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by paikhantko on 7/7/18.
 */

public class SuccessGetWarDeeEvent {
    private List<WarDeeVO> warDees;

    public SuccessGetWarDeeEvent(List<WarDeeVO> warDees) {
        this.warDees = warDees;
    }

    public List<WarDeeVO> getWarDees() {
        return warDees;
    }
}
