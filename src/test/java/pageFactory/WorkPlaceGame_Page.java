package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.WaitHelper;

public class WorkPlaceGame_Page {
    WebDriver driver;
    WaitHelper waitHelp;

    public WorkPlaceGame_Page(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        waitHelp= new WaitHelper(driver);

    }

    @FindBy(id="start")
    WebElement gameStartButton;

    @FindBy(id="office_answer_1")
    WebElement safeoption;

    @FindBy(xpath ="//*[@id='staticBackdropLabel' and contains(text(),'That is correct!')]")
    WebElement result;

    @FindBy(id="leaderboard_link")
    WebElement scoreboard;

    @FindBy(id="img-protection_poster")
    WebElement timeUpImage;

    public void clickonStartButton()
    {
        boolean startButton=gameStartButton.isDisplayed();
        if(startButton==true){
            gameStartButton.click();
        }

    }

    public void clickSafeOption()
    {
        safeoption.click();

    }

    public void checkTheResult()
    {
        boolean resultVisible=result.isEnabled();
        Assert.assertTrue("Result not Displayed",resultVisible);

    }

    public void cilckFinalScoreButton()
    {
        scoreboard.click();

    }

    public void WaitForTimeOut()throws InterruptedException
    {
        waitHelp.WaitForElement(timeUpImage,30);

    }

    public void VerifyTimeOut()
    {
        boolean timeUpImageVisible=timeUpImage.isEnabled();
        Assert.assertTrue("Timeout,Click the button try again to continue",timeUpImageVisible);

    }

}

