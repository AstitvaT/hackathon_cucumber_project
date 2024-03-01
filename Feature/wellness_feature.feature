Feature:  Corporate Wellness
 
  Scenario: Schedule a demo by passing valid and invalid details of the employees
    Given The user Navigates to the practo Webpage
    Then Clicks on the Health and Wellness plan under For Corporate section and fills the form with invalid email and Checks whether the schedule button is disabled
    And Fills the form with valid email  and clicks on schedule demo button to capture the thankyou message