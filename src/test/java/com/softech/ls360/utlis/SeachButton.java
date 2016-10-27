package com.softech.ls360.utlis;

/**
 * Created by syed.musab on 10/27/2016.
 */
public class SeachButton {

    private String searchButtons;

    public SeachButton(String searchButton){

        this.searchButtons = searchButton;
    }

    @Override
    public String toString(){
        return searchButtons.toString();
    }
}
