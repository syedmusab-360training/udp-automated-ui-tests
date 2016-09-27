package com.softech.ls360.runners.udp;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by zuhair.mukry on 9/26/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/udp_learner_courses"})
public class LearnerEnrolledCoursesTest {
}
