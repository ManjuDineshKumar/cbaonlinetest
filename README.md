# cbaonlinetest
Project name: cbaonlinetest

Project Description: This Project is for Automating the user journeys of Covid-19 Game Application. The Design model is Page Factory Pattern which driven by Cucumber BDD feature Files.

Installation (pre-requisites)

1.	JDK 1.8+ 

2.	Maven 

3.	Plugins for Maven, Cucumber and Junit

4.	Chrome and IE Browser driver

Project Structure:

•	drivers – This folder used for the drivers 

•	Log- This folder contains all the Log files

•	Properties- all the properties file used placed here

•	src\test\features- Feature file can found in the folder

•	src\test\java\pageFactory – This Package contains all the pages, definitions and actions

•	src\test\java\runners – This package contains the test run class which used to run the Cucumber tests

•	src\test\java\stepDefinitions – This Package contains the step definition Class 

•	src\test\java\ utilities– This package holds utilities class eg: waitHelper class

•	target – This folder contains all the reports generated as part of the test execution 


How to Run the test

Run the Class- src\test\java\runners\TestRun.java 

This will run all the test Scenarios in the feature file. 

Cucumber has no BeforeAll and AfterAll hooks, so we can’t open a single browser at the start of the test suite, navigate to the relevant page in the setup for each individual test scenario and close the browser at the end of the test suite. Having a separate browser per test allows test parallelisation.
If you need to Any particular test scenario, need to add a tag in the feature file and same need to be added in runner class

Eg :
Feature File – add the tag before the scenario, you wish to run

@thisScnario

  Scenario Outline: Covid-19 Game Default user Creation
  Given I Open …..........


TestRun Class: needs to be updated the tag added in the feature file to run the scenario 

@CucumberOptions
        (
                features = {"src/test/features/Covid19GameApplication.feature"},
                glue = "stepDefinitions",                
                tags = "@thisScnario"      


Test Report:

After each Test Run, Reports will be generated. Plugin used generate the report in HTML and JSON, Report. Sample Reports are available in the folder



