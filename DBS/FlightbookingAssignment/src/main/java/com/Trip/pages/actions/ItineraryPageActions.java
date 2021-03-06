package com.Trip.pages.actions;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Trip.page.locators.ItineraryPageLocators;
import com.Trip.utlity.SeleniumDriver;
import com.cucumber.listener.Reporter;


public class ItineraryPageActions {
	public static List<String> onWardFlightDetailsItineraryPage=new ArrayList<String>();
	public static List<String> returnFlightDetailsItineraryPage=new ArrayList<String>();
	ItineraryPageLocators itinaryPageloc=null;
	
	public ItineraryPageActions()
	{
		itinaryPageloc=new ItineraryPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), itinaryPageloc);
	}
	
	public void getOnwardJourneyFlightDetails()
	{
		List<WebElement>details=itinaryPageloc.itinerary_onWardJourney.findElements(By.tagName("li"));
		System.err.println("count:"+details.size());
		onWardFlightDetailsItineraryPage.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
		onWardFlightDetailsItineraryPage.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		onWardFlightDetailsItineraryPage.add(details.get(2).getText());
		onWardFlightDetailsItineraryPage.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
	

		System.err.println(details.get(0).findElement(By.cssSelector("span.name")).getText());
		System.err.println(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		System.err.println(details.get(2).getText());
		System.err.println(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		
	}

	public void getReturnJourneyFlightDetails()
	{
		List<WebElement>details=itinaryPageloc.itinerary_returnJourney.findElements(By.tagName("li"));
		System.err.println("count:"+details.size());
		returnFlightDetailsItineraryPage.add(details.get(0).findElement(By.cssSelector("span.name")).getText());
		returnFlightDetailsItineraryPage.add(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		returnFlightDetailsItineraryPage.add(details.get(2).getText());
		returnFlightDetailsItineraryPage.add(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		
	
		System.err.println(details.get(0).findElement(By.cssSelector("span.name")).getText());
		System.err.println(details.get(1).findElement(By.cssSelector("span.placeTime")).getText());
		System.err.println(details.get(2).getText());
		System.err.println(details.get(3).findElement(By.cssSelector("span.placeTime")).getText());
		
	}
	
	
	
	
	
}

