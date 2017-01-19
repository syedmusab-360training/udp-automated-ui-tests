package com.softech.ls360.runners.gmail_webtest.steps.serenity;

import com.softech.ls360.pages.gmailWebtest.GmailWebtest;
import net.thucydides.core.annotations.Step;

/**
 * Created by syed.musab on 11/28/2016.
 */
public class GmailTestSteps {

        GmailWebtest gmailWebtest;

    @Step
    public void openGmail() {

        gmailWebtest.node();
        gmailWebtest.enterUsernameValue();
    }


}
