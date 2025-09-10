package steps;

import io.cucumber.java.en.*;
import static org.testng.Assert.assertEquals;


public class StepDefinitions {

    private String input1;
    private String input2;
    private String result;
    private String errorMessage;


    // For adding decimal numbers
    @Given("I enter {double} and {double}")
    public void i_enter_and(Double num1, Double num2) {
        input1 = num1.toString();
        input2 = num2.toString();
    }

    @When("I press the add button")
    public void i_press_the_add_button() {
        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            result = String.valueOf(num1 + num2);
            errorMessage = null;
        } catch (NumberFormatException e) {
            result = null;
            errorMessage = "Invalid input";
        }
    }



    // For invalid input (number + letter)
    @Given("I enter {int} and {string}")
    public void i_enter_and(int number, String text) {
        input1 = String.valueOf(number);
        input2 = text;
    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedMessage) {
        assertEquals(expectedMessage, errorMessage);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        assertEquals(expected, result);
    }
}