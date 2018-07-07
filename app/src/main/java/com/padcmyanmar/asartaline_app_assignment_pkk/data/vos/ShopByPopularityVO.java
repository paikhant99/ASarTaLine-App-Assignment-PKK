package com.padcmyanmar.asartaline_app_assignment_pkk.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by paikhantko on 7/7/18.
 */

public class ShopByPopularityVO {

    @SerializedName("shopByPopularityId")
    private String shopByPopularityId;

    @SerializedName("mealShop")
    private MealShopVO mealShop;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }
}
