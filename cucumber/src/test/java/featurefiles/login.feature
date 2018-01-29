Feature: Testing login funcionality

  @login @ui
  Scenario: Login functionality with valid data
    Given user is in login page
    When user enters username "temp@tester.com" and password "12345"
    And clicks on login button
    Then user can see user home page
    And user can do logout

	@listdata @ui
  Scenario: login with valid crendentials
    Given user is in login page
    When user enter username, password and click on login button
      | "temp@tester.com" | "12345"  |
      | "temp@temp.com "  | "12345"  |
      | "temp@tester.com" | "123456" |
    Then user can see user home page with logout link

  #Scenario: login with invalid username
  #	Given user is in login page
  #	When user enter invalid username and valid passotd and click on login button
  #	Then user can see authentication error
  #
  #Scenario: login with invalid password
  #	Given user is in login page
  #	When user enter valid username and invalid passotd and click on login button
  #	Then user can see authentication error
  @datatable @api
  Scenario Outline: login with different sets of data
    Given user is in login page
    When user enters username <username> and password <password>
    And clicks on login button
    Then user can see related output <output>

    Examples: 
      | username          | password | output                 |
      | "temp@tester.com" | "12345"  | "logout"               |
      | "temp@temp.com "  | "12345"  | "authentication error" |
      | "temp@tester.com" | "123456" | "authentication error" |
