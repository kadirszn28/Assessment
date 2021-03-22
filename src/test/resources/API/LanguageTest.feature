Feature: Language section API Test

  Scenario: Positive Test of Language API
    When User sends GET request
    Then User validates status code 200
    And User validates following attributes
      | languageDescription | languageCode | proxyLocation | eshopLanguageCode | brand |
      | English             | en           | www           | en-IE             | VS    |


