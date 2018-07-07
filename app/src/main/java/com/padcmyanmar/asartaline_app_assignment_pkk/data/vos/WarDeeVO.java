package com.padcmyanmar.asartaline_app_assignment_pkk.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by paikhantko on 7/7/18.
 */

public class WarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String warDeeName;

    @SerializedName("images")
    private List<String> warDeeImages;

    @SerializedName("generalTaste")
    private List<TasteVO> generalTastes;

    @SerializedName("")
    private List<SuitedForVO> suitedFors;

    @SerializedName("priceRangeMin")
    private int priceRangeMin;

    @SerializedName("priceRangeMax")
    private int priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<WarDeeVO> matchWarDeeList;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopsByDistance;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopsByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getWarDeeName() {
        return warDeeName;
    }

    public List<String> getWarDeeImages() {
        return warDeeImages;
    }

    public List<TasteVO> getGeneralTastes() {
        return generalTastes;
    }

    public List<SuitedForVO> getSuitedFors() {
        return suitedFors;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<WarDeeVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopsByDistance() {
        return shopsByDistance;
    }

    public List<ShopByPopularityVO> getShopsByPopularity() {
        return shopsByPopularity;
    }
}
