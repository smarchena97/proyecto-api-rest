Feature: Obtener PQRS
  Como usuario de la API
  Quiero poder obtener una PQRS existente
  Para poder ver su información

  Scenario: Obtener PQRS existente
    Given hay una PQRS con id 1 en la base de datos
    When se solicita obtener la PQRS con id 1
    Then se debe responder con un código de estado 200
    And la respuesta debe tener la información de la PQRS con id 1
