package com.softech.ls360.runners.number_of_my_courses;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 11/11/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/number_of_my_courses"})
public class NumberOfMyCoursesTest {
}
