Feature: Check Customer
  As a valid user, I should be able to check an existing customer using the customer Id
 
Scenario: Check Existing Balance
  Given a user has logged in with user id %mngr332204% and password %atEdasA%   
  And he is on the Balance Enquiry page
  When he submits %93608% as the account no  
  Then ensure the account no is %93608%
  And ensure the account type is %Savings%
  And ensure the account balance is %3000%
  
 