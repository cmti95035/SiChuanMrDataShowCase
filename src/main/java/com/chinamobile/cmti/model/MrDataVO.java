package com.chinamobile.cmti.model;

import java.io.Serializable;

public class MrDataVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String province;
    private String city;
    private String roadName;

    public MrDataVO(String province, String city, String roadName) {
        this.province = province;
        this.city = city;
        this.roadName = roadName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    @Override
    public String toString() {
        return "MrDataVO [province=" + province + ", city=" + city + " ,road name=" + roadName + "]";
    }
}
