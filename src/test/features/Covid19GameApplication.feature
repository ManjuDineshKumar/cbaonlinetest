Feature: COVID-19 THE GAME application

  Scenario Outline: Covid-19 Game Default user Creation
    Given I Open the  COVID19 GAME Application
    When I click create warrior
    Then Default User is created and start your Journey button is displayed with Default warrior name <Defaultwarrior>

    Examples:
      | Defaultwarrior |
      | guest          |

  Scenario Outline: Covid-19 Game User Creation
    Given I Open the  COVID19 GAME Application
    When I Enter warrior name <warriorname> and click create warrior
    Then User is created and start your Journey button is displayed with warrior name <warriorname>

    Examples:
      | warriorname |
      | tes         |

  Scenario Outline: User Journey of Successful Public Transport warrior battle field game and check the leadership board
    Given I Open the  COVID19 GAME Application
    When I Enter warrior name <warriorname> and click create warrior
    Then start your Journey button is displayed and I click on the button to start the game
    Then it routed to the Battle Field game Home page To Select the battle
    When I click on the Public Transport Game
    Then Public bus game start button is displayed and click on the button to start
    When I click on the Safe option
    Then I can see the result
    When I click the final score button
    Then I will see the leadership board for the final score of warrior <warriorname>

    Examples:
      | warriorname |
      | tes         |

  Scenario Outline: User Journey of Successful Public place battle field game and check the leadership board
    Given I Open the  COVID19 GAME Application
    When I Enter warrior name <warriorname> and click create warrior
    Then start your Journey button is displayed and I click on the button to start the game
    Then it routed to the Battle Field game Home page To Select the battle
    When I click on Go to a public place Game button
    Then seated at a Resturant game start button is displayed and click on the button to start the game
    When I click on the Safe option for the the public place game
    Then I can see the result for the public place game
    When I click the final score button to check the score after public place game
    Then I will see the leadership board for the final score of warrior <warriorname>

    Examples:
      | warriorname |
      | tes         |

  Scenario Outline: Successful Work place battle field game Journey and check the leadership board
    Given I Open the  COVID19 GAME Application
    When I Enter warrior name <warriorname> and click create warrior
    Then start your Journey button is displayed and I click on the button to start the game
    Then it routed to the Battle Field game Home page To Select the battle
    When I click on Go to the office Game button
    Then Working at home game start button is displayed and click on the button to start the game
    When I click on the Safe option for the work place game
    Then I can see the result for the work place game
    When I click the final score button to check the score after work place game
    Then I will see the leadership board for the final score of warrior <warriorname>

    Examples:
      | warriorname |
      | tes         |

  Scenario Outline: Timeout Journey of Warrior Game
    Given I Open the  COVID19 GAME Application
    When I Enter warrior name <warriorname> and click create warrior
    Then start your Journey button is displayed and I click on the button to start the game
    Then it routed to the Battle Field game Home page To Select the battle
    When I click on Go to the office Game button
    Then Working at home game start button is displayed and click on the button to start the game
    When I am not performing any Action for few Seconds
    Then Timeout message is Displayed

    Examples:
      | warriorname |
      | tes         |

