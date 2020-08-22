@todos
Feature: Todos

  Background: 
    Given Page Should Contain Element input text description

  @addtodo
  Scenario: I can add a todo
    When Submit a todo "Adopter de bonnes pratiques de test"
    Then Element Should Contain "Adopter de bonnes pratiques de test"
    And Checkbox Should Not Be Selected

  @selecttodo
  Scenario: I can select a todo
    When Submit a todo "Adopter de bonnes pratiques de test"
    And Submit a todo "Comprendre le Keyword-Driven Testing"
    And Submit a todo "Automatiser des cas de test avec Robot Framework"
     Then First Element Should Contain "Adopter de bonnes pratiques de test"
    And Second Element Should Contain "Comprendre le Keyword-Driven Testing"
    And Third Element Should Contain "Automatiser des cas de test avec Robot Framework"
    When Select first Checkbox todo
    Then First Checkbox Should Be Selected
    And Second Checkbox Should Not Be Selected
    And Third Checkbox Should Not Be Selected

  @removetodo
  Scenario: I can remove a todo
    When Submit a todo "Choisir le bon type de framework de test"
    Then Page Should Contain button remove todo
    When Click button remove todo
    Then Page Should Not Contain Element "Choisir le bon type de framework de test"

  @categorizetodo
  Scenario: I can categorize some todos
    When Submit a todo "Choisir un livre intéressant"
    Then Page Should Not Contain Element category "Personnel" and "Professionnel"
    When select category "Personnel"
    When Submit a todo "Marcher et faire du vélo avec mon chien"
    Then First Element Text Should Be category "Personnel"
    When Submit a todo "Faire un câlin avec mon chat"
    Then Second Element Text Should Be category "Personnel"
    When select category "Professionnel"
    When Submit a todo "Automatiser un cas de test de plus"
    Then Third Element Text Should Be category "Professionnel"
