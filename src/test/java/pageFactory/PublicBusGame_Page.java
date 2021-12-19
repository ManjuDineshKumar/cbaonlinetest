package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.WaitHelper;

public class PublicBusGame_Page {
    WebDriver driver;
    WaitHelper waitHelp;

    public PublicBusGame_Page(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        waitHelp= new WaitHelper(driver);

    }

    @FindBy(id="bus_timer_start")
    WebElement gameStartButton;

    @FindBy(id="bus_answer_1")
    WebElement safeoption;

    @FindBy(xpath ="//*[@id='staticBackdropLabel' and contains(text(),'That is correct!')]")
    WebElement result;

    @FindBy(id="leaderboard_link")
    WebElement scoreboard;

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

}
