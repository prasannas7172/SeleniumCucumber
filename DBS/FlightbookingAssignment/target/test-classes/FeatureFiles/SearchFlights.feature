@Chrome @Firefox
@Book_Tikect
Feature: FightBooking.
  In order to select the best iteinerary fatest and cheapestflight 
  
	
  @clearTripExecise
  Scenario Outline: Validate Booking flight
    Given I am on the Home Page <url> of cleartrip Website
    Then I click on Flights Button
    Then I select RoundTrip radioButton
    Then I enter <From> and <To> values 
    Then I enter <Departure> and <ReturnDate>
    Then I select <adults> and <childs>
    Then I click on Search Flights
    Then I select <depart> Flight and <retur> flight to book tickets
    Then I wait For Results to Apper on the Screen
    Then I read departure Flights <specific> rowData
    Then I read Return Flights <specific> rowData
    Then I Book the Tickets
    Then I read ItenaryDetails
    
    
    
    Examples:  
   |url 												|  From    					|  To   								 |Departure 		 |ReturnDate  |adults|childs|specific|depart|retur|
   | "https://www.cleartrip.com"| "Hyderabad"     	| "Vishakhapatnam"        |"25/08/2020"  |"26/08/2020"|"1"   |"0"   |1       |1     |1    |
   
    
