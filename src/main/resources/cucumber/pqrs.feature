Feature: PQRS API
  Scenario: Crear una nueva PQRS
    Given Una solicitud de PQRS
    When La solicitud es enviada a la API
    Then La respuesta HTTP es 200
    And La PQRS es creada en la base de datos

  Scenario: Obtener todas las PQRS
    Given Al menos una PQRS en la base de datos
    When La solicitud es enviada a la API para obtener todas las PQRS
    Then La respuesta HTTP es 200
    And Todas las PQRS son retornadas

  Scenario: Actualizar una PQRS existente
    Given Una PQRS existente en la base de datos
    When La solicitud es enviada a la API para actualizar la PQRS
    Then La respuesta HTTP es 200
    And La PQRS es actualizada en la base de datos

  Scenario: Eliminar una PQRS existente
    Given Una PQRS existente en la base de datos
    When La solicitud es enviada a la API para eliminar la PQRS
    Then La respuesta HTTP es 200
    And La PQRS es eliminada de la base de datos
