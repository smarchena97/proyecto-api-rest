Feature: Crear PQRS

  Scenario: Crear una nueva PQRS
    Given que envío una solicitud POST a "/api/pqrs" con los siguientes datos:
      | nombre        | tipo      | tema            | descripcion             | estatus    |
      | PQRS de prueba | Peticion  | Problemas tecnicos | La aplicación no funciona | Enviado |
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener los siguientes datos:
      | nombre        | tipo      | tema            | descripcion             | estatus    |
      | PQRS de prueba | Peticion  | Problemas tecnicos | La aplicación no funciona | Enviado |

  Scenario: Crear una PQRS inválida
    Given que envío una solicitud POST a "/api/pqrs" con los siguientes datos:
      | nombre   | tipo     | tema | descripcion | estatus |
      |          | Peticion |      |             | Enviado |
    Then la respuesta debe tener un código de estado 400
    And la respuesta debe contener los siguientes errores:
      | campo      | mensaje                   |
      | nombre     | El nombre es obligatorio  |
      | tema       | El tema es obligatorio    |
      | descripcion | La descripcion es obligatoria |

