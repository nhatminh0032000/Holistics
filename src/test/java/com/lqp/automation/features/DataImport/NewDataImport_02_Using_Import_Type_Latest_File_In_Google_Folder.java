package com.lqp.automation.features.DataImport;

import com.lqp.automation.steps.DataImport;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by thuan549 on 5/1/2017.
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class NewDataImport_02_Using_Import_Type_Latest_File_In_Google_Folder {
    @Managed
    WebDriver driver;
    @Steps
    DataImport dataImport;

    @Before
    public void beforeMethod(){

    }

    //Because we cannot delete the table which is created so we just test import data succcessful
    //do not test table which is created in database.
    String shareLinkGoogleDrive="https://drive.google.com/open?id=0Bxpqo2ZlHelPS1lZSG1LOVlqQ0E";
    String sourceTypeSelection ="Latest File in Google Folder";

    @Test
    public void NewDataImport_02_Using_Import_Type_Latest_File_In_Google_Folder(){
        dataImport.shouldAbleToLogin();
        dataImport.openLeftNav();
        dataImport.openDataImportPage();
        dataImport.openNewDataImport();
        dataImport.dataImportName("Auto Banks");
        dataImport.importSource(shareLinkGoogleDrive,sourceTypeSelection);
        dataImport.selectImportDestination();
        dataImport.syncConfiguration();
        dataImport.clickSaveButton();
        dataImport.checkDataImportLoaded(); //after creating, the Data import page should be loaded.
    }
    @After
    public void afterMethod(){

    }
}
