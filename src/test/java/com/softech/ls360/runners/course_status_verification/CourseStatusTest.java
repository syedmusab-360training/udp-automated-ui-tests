package com.softech.ls360.runners.course_status_verification;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 10/28/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/udp_course_status_verification"})
public class CourseStatusTest {
}
