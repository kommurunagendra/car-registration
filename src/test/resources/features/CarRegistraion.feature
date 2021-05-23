@car-reg-details
Feature: car registration

  Scenario: Reading input file and search each registration number and verify registration details with output file
    Given user navigates to car tax check site and read registation numbers from input file car_input.txt
    When  i enter registration number and click on search button
    Then  verify the car registration details with output file car_output.txt
