package com.softech.ls360.utlis;

/**
 * Created by syed.musab on 11/15/2016.
 */
public class ClassroomGearOptions {

    private String gearDropdown;

    public ClassroomGearOptions(String gearDropdown) {

        this.gearDropdown = gearDropdown;
    }

    @Override
    public String toString() {
        return gearDropdown.toString();
    }
}

