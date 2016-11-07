package com.softech.ls360.runners.mycourses_content_verification;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 10/19/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/udp_home_page_verification"})
public class HomepageVerificationTest {
}
