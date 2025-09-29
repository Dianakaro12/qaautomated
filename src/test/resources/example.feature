Feature: Add two numbers

  @XrayTestKey=QA-1 @QA_PROJECT @Cucumber @QA-2
  Scenario: Add two decimal numbers
    Given I enter 2.5 and 3.1
    When I press the add button
    Then the result should be "5.6"

  @XrayTestKey=QA-1 @QA_PROJECT @Cucumber @QA-3
  Scenario: Enter a number and a letter
    Given I enter 2 and "a"
    When I press the add button
    Then the message "Invalid input" should be displayed

  @XrayTestKey=QA-1 @QA_PROJECT @Cucumber @QA-11
  Scenario: Intentional failure to test screenshot and Xray
    Given I enter 1 and 2
    When I press the add button
    Then the result should be "10"
