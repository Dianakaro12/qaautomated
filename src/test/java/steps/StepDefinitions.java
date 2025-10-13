package steps;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class StepDefinitions {

    private String input1;
    private String input2;
    private String result;
    private String errorMessage;

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
            double sum = num1 + num2;

            // 🔧 Si la suma es entera, quitar el .0
            result = (sum % 1 == 0)
                    ? String.valueOf((int) sum)
                    : String.valueOf(sum);

            errorMessage = null;
        } catch (NumberFormatException e) {
            result = null;
            errorMessage = "Invalid input";
        }
    }

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
    public void the_result_should_be(String expectedResult) {
        if (result == null || !result.equals(expectedResult)) {
            throw new AssertionError("Expected result: " + expectedResult + " but was: " + result);
        }
    }
}
