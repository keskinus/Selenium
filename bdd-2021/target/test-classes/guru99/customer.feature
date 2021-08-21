Feature: Check Customer
  As a valid user, I should be able to check an existing customer using the customer Id
 
Scenario: Check Existing Customer
  Given a user has logged in with user id %mngr329585% and password %ujunahu%
  And he is on the Edit Customer page
  When he submits %96296% as the customer id
  Then ensure the customer name is %John%
  And ensure the customer gender is %male%
  And ensure the customer dob is %1990-10-10%