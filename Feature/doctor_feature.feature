Feature: Print Doctors

  Scenario: Printing top five doctors in a city after applying respective filters
    Given user Navigates to the Practo Webpage
    Then selects a desired city
    Then searches any doctor  in that city
    When sort by number of patients stories
    And apply filters of Experience
    And apply filter of Fees
    And apply filter of Availability
    And sort by relevance
    Then print the details
