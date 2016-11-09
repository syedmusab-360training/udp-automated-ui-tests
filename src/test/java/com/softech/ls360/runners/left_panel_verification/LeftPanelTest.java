package com.softech.ls360.runners.left_panel_verification;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 10/21/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/udp_leftpanel_menu_verification/leftnavigation_manager_menu.feature"})
public class LeftPanelTest {
}
