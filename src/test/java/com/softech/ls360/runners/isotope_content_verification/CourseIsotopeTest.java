package com.softech.ls360.runners.isotope_content_verification;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by syed.musab on 11/3/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/isotope_content_verification"})
public class CourseIsotopeTest {
}
