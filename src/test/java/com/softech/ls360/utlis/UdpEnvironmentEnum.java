package com.softech.ls360.utlis;

/**
 * Created by syed.musab on 11/22/2016.
 */
public enum UdpEnvironmentEnum {

    WLCMS_URL_ENV_QA("https://qa-lms.360training.com/lms/login.do", "qa");

    private String udpUrlEnvironmentValue;
    private String udpEnvironmentName;

    UdpEnvironmentEnum(String udpUrlEnvironmentValue, String udpEnvironmentName){

        this.udpUrlEnvironmentValue = udpUrlEnvironmentValue;
        this.udpEnvironmentName = udpEnvironmentName;
    }

    public String getUdpUrlEnvironmentValue(){

        return udpUrlEnvironmentValue;
    }

    public String getUdpEnvironmentName(){

        return udpEnvironmentName;
    }
}
