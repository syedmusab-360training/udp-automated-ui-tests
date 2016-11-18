package com.softech.ls360.runners.learner_mode_verification;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 10/25/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/udp_learner_mode_login_verification"})
public class LmsLearnerModeTest {
}
