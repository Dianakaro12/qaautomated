package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {

    private int numero1 = -1;
    private int numero2 = -1;
    private int resultado;

    // Usamos un contador para saber si es el primer o segundo número
    @Given("que tengo el número {int}")
    public void que_tengo_el_numero(int num) {
        if (numero1 == -1) {
            numero1 = num;
        } else {
            numero2 = num;
        }
    }

    @When("los sumo")
    public void los_sumo() {
        resultado = numero1 + numero2;
    }

    @When("los multiplico")
    public void los_multiplico() {
        resultado = numero1 * numero2;
    }

    @Then("el resultado debería ser {int}")
    public void el_resultado_deberia_ser(int esperado) {
        System.out.println("El resultado es: " + resultado);
        assertEquals(esperado, resultado);
    }
}
