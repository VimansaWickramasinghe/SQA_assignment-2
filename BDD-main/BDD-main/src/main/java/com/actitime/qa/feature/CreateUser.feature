
  Feature: As an admin user, I want to create a new user



    @TC_001
    Scenario Outline: Successful new user creation
      Given Admin user log into actiTime application and enter "<username>" and "<password>" and go to Users Page
      When Admin user click on New User button
      Then Admin user enter the First Name as "<name>"
      Then Admin user enter the Last Name as "<lastName>"
      Then Admin user enter the Email as "<email>"
      Then Admin user click on Save button
      Then Admin User should be able to successfully add a new user with email as "<confirmEmail>"
      Examples:
        | name  | lastName | email | confirmEmail | username | password |
        | Hasa | Savindra | hasa@gmail.com | hasa@gmail.com | viduwickram@gmail.com |qwe123@Z |
