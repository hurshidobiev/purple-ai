Feature: Admin user login

  Scenario: Login page contains sign-in logo
    Given admin user is on the login page
    Then sign-in logo is displayed


  Scenario Outline: Verify admin user login
    Given admin user is on the login page
    When the user enters "<username>" and "<password>"
    Then the user should see "<pageTitle_errorMessage>"

    Examples:
      | username      | password      | pageTitle_errorMessage               |
#      | validUsername | validPassword | Purple                               |
      | wrongUsername | password      | Username or password not recognised. |
      | username      | wrongPassword | Username or password not recognised. |
      |               | password      | Username or password not recognised. |
      | username      |               | Sorry, we are unable to log you in.  |