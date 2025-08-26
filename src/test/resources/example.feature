Feature: Suma simple

  Scenario: Sumar dos números
    Given que tengo el número 2
    And que tengo el número 3
    When los sumo
    Then el resultado debería ser 5

  Scenario: Multiplicar dos números
    Given que tengo el número 4
    And que tengo el número 5
    When los multiplico
    Then el resultado debería ser 20
