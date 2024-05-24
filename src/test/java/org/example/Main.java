package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    private WebDriver webDriver;
    private final String LINK = "https://cloud.google.com/";
    private PricingCalculator pCalc;
    private ComputeEngine cEngine;
    private Summary summary;

    @BeforeClass
    public void setup(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        webDriver = new EdgeDriver(options);
        webDriver.get(LINK);

        pCalc = new PricingCalculator(webDriver);
        cEngine = new ComputeEngine(webDriver);
        summary = new Summary(webDriver);

    }
    @Test
    public void navigateToCreateComputeEngine() throws InterruptedException {
// Form data has different fields and there is no possibility to fulfill the exercise
        pCalc.searchText("Google Cloud Platform Pricing Calculator");
        pCalc.clickOnPricingCalcLink();
        pCalc.clickOnAddToEstamateBtn();
        pCalc.clickOnComputeEngine();

        cEngine.numberOfInstances();
        cEngine.selectDropdownSystem();
        cEngine.provisioningModel();
        cEngine.machineType();
        cEngine.addGpus();
        cEngine.shareEstimateBtn();

        summary.openEstSummary();
        Assert.assertTrue(summary.verifyEstSummary(3).contains("n1-standard-8, vCPUs: 8, RAM: 30 GB"));
        Assert.assertTrue(summary.verifyEstSummary(5).contains("NVIDIA Tesla V100"));
        Assert.assertTrue(summary.verifyEstSummary(6).contains("1"));
        Assert.assertTrue(summary.verifyEstSummary(7).contains("2x375 GB"));
        Assert.assertTrue(summary.verifyEstSummary(11).contains("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"));
        Assert.assertTrue(summary.verifyEstSummary(12).contains("Regular"));
        Assert.assertTrue(summary.verifyEstSummary(18).contains("Frankfurt (europe-west3)"));
    }
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        webDriver.quit();
//    }
}
