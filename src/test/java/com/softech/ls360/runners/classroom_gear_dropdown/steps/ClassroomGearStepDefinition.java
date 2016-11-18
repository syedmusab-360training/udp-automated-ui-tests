package com.softech.ls360.runners.classroom_gear_dropdown.steps;

import com.softech.ls360.runners.classroom_gear_dropdown.steps.serenity.ClassroomGearSteps;
import com.softech.ls360.utlis.ClassroomGearOptions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by syed.musab on 11/15/2016.
 */
public class ClassroomGearStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomGearStepDefinition.class);
    private List<ClassroomGearOptions> gearIconList = new ArrayList<ClassroomGearOptions>();;

    @Steps
    ClassroomGearSteps classroomGearSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() {

        classroomGearSteps.opens_login_page();
    }

    @When("^user enters in udp homepage and click gear icon from classroom isotope$")
    public void user_enters_in_udp_homepage_and_click_gear_icon_from_classroom_isotope() {

        classroomGearSteps.valid_userName_password();
        classroomGearSteps.click_signIn_button();
        classroomGearSteps.homepageIsDisplayed();
        classroomGearSteps.clickGearDropdown();

    }

    @Then("^it should display all following options$")
    public void it_should_display_all_following_options(DataTable dataTable) {

        gearIconList = dataTable.asList(ClassroomGearOptions.class);

        logger.info("list is here" + gearIconList.get(0).toString());
        assertThat(classroomGearSteps.clickPrepareForClassroom(), equalToIgnoringCase(gearIconList.get(0).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("check your system is here" + gearIconList.get(1).toString());
        assertThat(classroomGearSteps.clickCheckYourSystem(), equalToIgnoringCase(gearIconList.get(1).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("Network & Bandwidth is here" + gearIconList.get(2).toString());
        assertThat(classroomGearSteps.networkAndBandwidth(), equalToIgnoringCase(gearIconList.get(2).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("Lync Demonstration" + gearIconList.get(3).toString());
        assertThat(classroomGearSteps.lyncDemonstration(), equalToIgnoringCase(gearIconList.get(3).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("Lab Demonstration" + gearIconList.get(4).toString());
        assertThat(classroomGearSteps.labDemonstration(), equalToIgnoringCase(gearIconList.get(4).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("My Courseware Window" + gearIconList.get(5).toString());
        assertThat(classroomGearSteps.myCoursewarWindow(), equalToIgnoringCase(gearIconList.get(5).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

        logger.info("Support Window" + gearIconList.get(6).toString());
        assertThat(classroomGearSteps.supportWindow(), equalToIgnoringCase(gearIconList.get(6).toString()));
        assertTrue(classroomGearSteps.switchToMoviePopupClassroom());

    }
}
