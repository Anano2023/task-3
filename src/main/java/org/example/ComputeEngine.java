package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputeEngine {
   private final WebDriver driver;
   private final WebDriverWait wait;
   @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[7]/div/div/div/div/div/div/div")
   private WebElement selectDropdownSystemList;
   @FindBy(xpath = "//li[@data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']")
   private WebElement operatingSystem;
   @FindBy(xpath = "//label[@for='regular']")
   private WebElement modelRegular;
   @FindBy(xpath = "(//div[@jsname='wSASue']/div/div)[position()=5]")
   private WebElement mFamily;
    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div/div/div/div/div[2]/ul/li[1]")
            //"(//div[@data-menu-uid='ucj-28']/ul/li/span[2])[position()=1]")
   private WebElement chooseGeneralPurpose;
    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[2]/div/div/div/div/div")
    private WebElement seriesDropdown;
    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/ul/li[1]")
    private WebElement chooseSeries;
    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[3]/div/div/div/div/div")
    private WebElement machineType;
    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/ul/li[7]")
    private WebElement chooseMachineType;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement gpuBtn;

    @FindBy(xpath = "(//div[@jsname='oYxtQd']//div[@class='VfPpkd-aPP78e'])[position()=8]")
    private WebElement gpuModel;

    @FindBy(xpath = "/html/body/div[6]/md-select-menu/md-content/md-option[4]")
            //(xpath = "(//span[@class='VfPpkd-uusGie-fmcmS-haAclf'])[position()=8]")
    private WebElement nvidiaV100;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=9]")
    private WebElement gpuNumberDropdown;
    @FindBy(xpath = "(//span[@class='VfPpkd-rymPhb-fpDzbe-fmcmS' and @jsname='K4r5Ff' and contains(text(), '1')])[position()=34]")
    private WebElement chooseGpuNumber;


    @FindBy(xpath = "(//span[@class='VfPpkd-rymPhb-fpDzbe-fmcmS' and @jsname='K4r5Ff' and contains(text(), '1')])[position()=34]")
    private WebElement gpuNumberOption;

    @FindBy(xpath = "(//div[@jsname='oYxtQd']/div[@class='VfPpkd-aPP78e'])[position()=10]")
    private WebElement ssd;

    @FindBy(xpath = "/html/body/div[8]/md-select-menu/md-content/md-option[3]/div[1]")
            //(xpath ="(//div[@data-menu-uid='ucj-70']/ul/li[3]/span[2])[position()=1]")
            //"(//div[@jsname='xl07Ob']/ul[@jsname='rymPhb']/li[3]//span[@class='VfPpkd-rymPhb-Gtdoyb'])[position()=10]")
    private WebElement ssdOption;

    @FindBy(xpath = "(//div[@jsname='xl07Ob']/ul[@jsname='rymPhb']/li[12])[position()=2]")
    private WebElement regionOption;

    @FindBy(xpath = "//div[@id='ucj-1']/div/div/div/div/div/div/div/div/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]/label")
    private WebElement usage;


    public ComputeEngine(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }
    public void numberOfInstances(){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".QiFlid > .BfUoNb > div:nth-child(3) .wX4xVc-Bz112c-RLmnJb")));
        for(int i=0; i<3; i++){
            el.click();
        }
    }

    public void selectDropdownSystem()
    {
        selectDropdownSystemList.click();
        wait.until(ExpectedConditions.visibilityOf(operatingSystem)).click();
    }
    public void provisioningModel(){
        modelRegular.click();
    }
    //@FindBy(xpath = "//div[@data-field-type='158']")
    //private WebElement gpusTypeDropDown;
//    @FindBy(xpath = "//span[@id='c33']/parent::*/parent::*")
//    private WebElement machineTypeDropdown;
    public void machineType(){
        wait.until(ExpectedConditions.visibilityOf(mFamily)).click();
        wait.until(ExpectedConditions.visibilityOf(chooseGeneralPurpose)).click();

        seriesDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(chooseSeries)).click();

        machineType.click();
        wait.until(ExpectedConditions.visibilityOf(chooseMachineType)).click();
    }
    public void addGpus(){
        gpuBtn.click();
        gpuModel.click();
        wait.until(ExpectedConditions.visibilityOf(nvidiaV100)).click();
        gpuNumberDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(chooseGpuNumber)).click();
        ssd.click();
        wait.until(ExpectedConditions.elementToBeClickable(ssdOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(regionOption)).click();
        usage.click();
    }

    public void shareEstimateBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

    // Scroll down the page by a specific pixel value (e.g., 500 pixels)
        js.executeScript("window.scrollBy(0, 900)");
        driver.findElement(By.xpath("(//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']/button)[position()=3]")).click();

    }
}
