package com.lqp.automation.features.DataTransformation;

import com.lqp.automation.steps.DataTransform;
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
public class NewDataTransform_001_Can_Create_Data_Transform_With_Type_Materialized_Incremental {
    @Managed
    WebDriver driver;
    @Steps
    DataTransform dataTransform;

    @Before
    public void beforeMethod(){

    }

    //Because we cannot delete the table which is created so we just test import data succcessful
    //do not test table which is created in database.
    String sourceTypeSelection ="Materialized (Incremental)";
    String dataTransformName="Auto Materialized Incremental";
    @Test
    public void NewDataTransform_001_Can_Create_Data_Transform_With_Transformation_Type_As_Materialized_Full(){
        dataTransform.shouldAbleToLogin();
        dataTransform.openLeftNav();
        dataTransform.openDataTransformationPage();
        dataTransform.openNewDataTransformation();
        dataTransform.newDataTransformationName(dataTransformName);
        dataTransform.transformationTypeSelection(sourceTypeSelection);
        dataTransform.dataSourceSelection("WPL-Production");
        dataTransform.enterTableName("BanksTransformation");
        dataTransform.enterQuery("select * from banks where ID < 20");
        dataTransform.validateQuery();
        dataTransform.previewAndAutoFillColumns();
        dataTransform.validateTableStructure();
        dataTransform.clickSaveButton();
        dataTransform.checkDataTransformationPageLoaded();
        dataTransform.verifyNewDataTransformationCreated(dataTransformName);
    }
    @After
    public void afterMethod(){

    }
}
