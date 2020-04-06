Feature: WeEnergy Login
  Scenario Outline: Validate the Successful login of User
    Given The User launches the WeEnergy website
    When Entering  "<email>" and "<password>"
    Then User is able to successfully login
    Then Close the browser


    Examples:
        | email | password |
        | livingston7@gmail.com | Jclivida@10 |
        


