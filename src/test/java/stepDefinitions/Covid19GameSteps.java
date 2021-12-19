package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageFactory.*;

public class Covid19GameSteps  {
    public WebDriver driver;
    public Covid19Game_Home_Page home;
    public BattleField_Landing_Page battle;
    public PublicBusGame_Page bus;
    public LearderShipBoard_Landing_Page score;
    public PublicPlaceGame_Page place;
    public WorkPlaceGame_Page work;
    public static Logger logger;
    public Properties configProperty;

    @Before
    public void setup() throws IOException {
        logger = Logger.getLogger("Covid19 game app");
        PropertyConfigurator.configure("Properties/log4j.properties");

        configProperty = new Properties();
        FileInputStream configPropertyFile = new FileInputStream("Properties/Config.properties");
        configProperty.load(configPropertyFile);
        String browsername = configProperty.getProperty("browser");

        if (browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperty.getProperty("chromebrowserpath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        if (browsername.equals("IE")) {
            System.setProperty("webdriver.ie.driver", configProperty.getProperty("iebrowserpath"));
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();

        }
        logger.info("<---Browser launched--->");

    }

    @Given("I Open the  COVID19 GAME Application")
    public void i_open_the_covid19_the_game_application() {
        home = new Covid19Game_Home_Page(driver);
        String urlname = configProperty.getProperty("url");
        driver.get(urlname);
        logger.info("<---Application Launched--->");

    }

   @When("^I Enter warrior name(.*) and click create warrior$")
    public void i_enter_warrior_name_and_click_create_warrior(String user) {
        String warrior = user;
        home.enterWarriorNameAndClickCreateWarrrior(warrior);
        logger.info("<---User Creation--->");

    }

    @When("I click create warrior")
    public void i_click_create_warrior() {
        home.clickCreateWarriorButton();
        logger.info("<---Deault User Creation--->");

    }

   @Then("^User is created and start your Journey button is displayed with warrior name (.*)$")
   public void user_is_created_and_start_your_journey_button_is_displayed_with_warrior(String warrior) {
        String user=warrior;
        home.enterWarriorNameAndClickCreateWarrrior(user);
        home.verifyUserCreationSuccessful(user);
       logger.info("<---User Created Successfully--->");

    }

    @Then("^Default User is created and start your Journey button is displayed with Default warrior name (.*)$")
    public void default_user_is_created_and_start_your_journey_button_is_displayed_with_default_warrior_name(String defaultUSer) {
        String user=defaultUSer;
        home.verifyUserCreationSuccessful(user);
        logger.info("<---Default User Created Successfully--->");

    }

    @Then("start your Journey button is displayed and I click on the button to start the game")
    public void start_your_journey_button_is_displayed_and_i_click_on_the_button_to_start_the_game() {
        home.clickToStartTheGame();
        logger.info("<---Game Journey Started--->");

    }

    @Then("it routed to the Battle Field game Home page To Select the battle")
    public void it_routed_to_the_battle_field_game_home_page_to_select_the_battle() {
        battle = new BattleField_Landing_Page(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String pageTitle = configProperty.getProperty("battleFieldPageTitle");
        battle.verifyGameTItle(pageTitle);
        logger.info("<---Game Battle Field Page Displayed--->");

    }

    @When("I click on the Public Transport Game")
    public void i_click_on_the_public_transport_game() {
        battle.clickOnTakeTheBusGame();
        logger.info("<---Take On the Bus Game Started--->");

    }

    @When("I click on Go to a public place Game button")
    public void i_click_on_go_to_a_public_place_game_button() {
        battle.clickOnGoToAPublicPlaceGame();
        logger.info("<---Go To A Public Place Game Started--->");

    }

    @When("I click on Go to the office Game button")
    public void i_click_on_go_to_the_office_game_button() {
        battle.clickOnGoToTheOfficeGame();
        logger.info("<---Go To The Office Game Started--->");

    }

    @Then("Public bus game start button is displayed and click on the button to start")
    public void public_bus_game_start_button_is_displayed_and_click_on_the_button_to_start() {
        bus = new PublicBusGame_Page(driver);
        bus.clickonStartButton();
        logger.info("<---Take On the Bus Game Launched--->");

    }

    @When("I click on the Safe option")
    public void i_click_on_the_safe_option() {
        bus.clickSafeOption();
        logger.info("<---Take On the Bus Game SafeOption Selected--->");

    }

    @Then("I can see the result")
    public void i_can_see_the_result() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        bus.checkTheResult();
        logger.info("<---Take On the Bus Game Result --->");

    }

    @When("I click the final score button")
    public void i_click_the_final_score_button() {
        bus.cilckFinalScoreButton();
        logger.info("<---Checking Final Score--->");

    }

    @Then("seated at a Resturant game start button is displayed and click on the button to start the game")
    public void seated_at_a_resturant_game_start_button_is_displayed_and_click_on_the_button_to_start_the_game() {
         place=new PublicPlaceGame_Page(driver);
         place.clickonStartButton();
        logger.info("<---Public Place Game Launched--->");

    }

    @When("I click on the Safe option for the the public place game")
    public void i_click_on_the_safe_option_for_the_the_public_place_game() {
        place.clickSafeOption();
        logger.info("<---Public Place Game SafeOption Selected--->");

    }

    @Then("I can see the result for the public place game")
    public void i_can_see_the_result_for_the_public_place_game() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        place.checkTheResult();
        logger.info("<---Public Place Game Result --->");

    }

    @When("I click the final score button to check the score after public place game")
    public void i_click_the_final_score_button_to_check_the_score_after_public_place_game() {
        place.cilckFinalScoreButton();
        logger.info("<---Checking Final Score--->");

    }

    @Then("Working at home game start button is displayed and click on the button to start the game")
    public void working_at_home_game_start_button_is_displayed_and_click_on_the_button_to_start_the_game() {
        work= new WorkPlaceGame_Page(driver);
        work.clickonStartButton();
        logger.info("<---WorkPlace Game Lanuched--->");

    }

    @When("I click on the Safe option for the work place game")
    public void i_click_on_the_safe_option_for_the_work_place_game() {
        work.clickSafeOption();
        logger.info("<---WorkPlace Game SafeOption Selected--->");

    }

    @Then("I can see the result for the work place game")
    public void i_can_see_the_result_for_the_work_place_game() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        work.checkTheResult();
        logger.info("<---WorkPlace Game Result --->");

    }

    @When("I click the final score button to check the score after work place game")
    public void i_click_the_final_score_button_to_check_the_score_after_work_place_game() {
        work.cilckFinalScoreButton();
        logger.info("<---Checking Final Score--->");

    }

    @Then("^I will see the leadership board for the final score of warrior(.*)$")
    public void i_will_see_the_leadership_board_for_the_final_score_of_warrior(String user) {
        String username = user;
        score = new LearderShipBoard_Landing_Page(driver);
        score.verifyLeadershipBoardTitle();
        score.verifyFinalScoreOfWarrior(user);
        logger.info("<--- Final Score--->");

    }

    @When("I am not performing any Action for few Seconds")
    public void i_am_not_performing_any_action_for_few_seconds() throws InterruptedException {
        work.WaitForTimeOut();
        logger.info("<--- Timeout Wait --->");

    }

    @Then("Timeout message is Displayed")
    public void timeout_message_is_displayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        work.VerifyTimeOut();
        logger.info("<--- It's Timeout--->");

    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();

    }

}



