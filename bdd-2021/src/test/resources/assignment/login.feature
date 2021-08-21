Feature: Customer Login
  As a customer, I can log in using valid user id and password
  
Scenario: Valid Login
  Given a user is on the login page
  When he enters %mngr332204% as user id
  And he enters %atEdasA% as password
  And he submits the correct credential
  Then ensure the Manger Id is %mngr332204%
  
Scenario: Login Failure
  Given a user is on the login page
  When he enters %mngr332204% as user id
  And he enters %ujunah31293871% as password
  And he submits the wrong credential
  Then ensure the alert message of %User or Password is not valid%
  
 