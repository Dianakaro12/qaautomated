@QA_PROJECT @Cucumber
Feature: Add two numbers

  @XrayTestKey=QA-1 @ESC_1
  Scenario: Add two decimal numbers
    Given I enter 2.5 and 3.1
    When I press the add button
    Then the result should be "5.6"

  @XrayTestKey=QA-2 @ESC_2
  Scenario: Enter a number and a letter
    Given I enter 2 and "a"
    When I press the add button
    Then the message "Invalid input" should be displayed

  @XrayTestKey=QA-3 @ESC_3
  Scenario: Intentional failure to test screenshot and Xray
    Given I enter 4 and 6
    When I press the add button
    Then the result should be "10"
