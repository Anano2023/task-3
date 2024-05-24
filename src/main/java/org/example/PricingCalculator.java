package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculator
{
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy (className = "YSM5S")
    private WebElement searchBtn;
    @FindBy(className = "qdOxv-fmcmS-wGMbrd")
    private WebElement searchInput;
    @FindBy(css = ".PETVs-OWXEXe-UbuQg")
    WebElement clickSearchBtn;
    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator']")
    private WebElement pricingCalcLink;
    @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
    private WebElement addEstBtn;
    @FindBy(className = "aHij0b-aGsRMb")
    private WebElement clickCompEng;

    public PricingCalculator(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    public void searchText(String text){
        searchBtn.click();
        searchInput.sendKeys(text);
        clickSearchBtn.click();
    //Perform click action
        Actions actions = new Actions(driver);
        int xCoordinate = 100; // Example x-coordinate
        int yCoordinate = 200; // Example y-coordinate
        actions.moveByOffset(xCoordinate, yCoordinate).click().perform();
    }

    public void clickOnPricingCalcLink(){
        wait.until(ExpectedConditions.elementToBeClickable(pricingCalcLink)).click();
    }
    public void clickOnAddToEstamateBtn() {
        addEstBtn.click();
    }
    public void clickOnComputeEngine(){
        wait.until(ExpectedConditions.elementToBeClickable(clickCompEng)).click();
    }
}
