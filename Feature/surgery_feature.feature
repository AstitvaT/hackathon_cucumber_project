Feature: Print Surgeries list

  Scenario: Printing list of all the surgeries provided by practo
    Given user Navigates to the practo Webpage
    When user clicks on surgery option
    Then print all the surgery options
