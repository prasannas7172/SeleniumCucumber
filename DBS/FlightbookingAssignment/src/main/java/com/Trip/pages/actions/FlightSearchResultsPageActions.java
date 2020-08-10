package com.Trip.pages.actions;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;

	import com.Trip.page.locators.FlightSearchResultsPageLocators;
	import com.Trip.page.locators.FlightsSearchPageLocators;
	import com.Trip.utlity.CommonMethods;
	import com.Trip.utlity.SeleniumDriver;
	import com.cucumber.listener.Reporter;

	public class FlightSearchResultsPageActions {
		
		FlightSearchResultsPageLocators flightSearchResultsPageLoc=null;
		
		public  FlightSearchResultsPageActions()
		{
			flightSearchResultsPageLoc=new FlightSearchResultsPageLocators();
			PageFactory.initElements(SeleniumDriver.getDriver(), flightSearchResultsPageLoc);
		}
		
		public WebElement getDepartureFlightsList()
		{
			return flightSearchResultsPageLoc.SearchResults_FromFlightsListView;
		}
		
		public WebElement getReturnFlightsList()
		{
			return flightSearchResultsPageLoc.SearchResults_ReturnFlightsListView;
		}
		
		public void clickBookTikcetsButton()
		{
			new CommonMethods().presenceOfTheElement(flightSearchResultsPageLoc.SearchResults_BookTicket).click();
			
		}
		
		public void clickToChooseDeparture_ReturnFlights(WebElement departList,WebElement returnList,int depart,int retu)
		{
			Reporter.addStepLog("Selecting " + depart +"Flight");
			WebElement departelement=departList.findElement(By.xpath("li["+depart+"]"));
			List<WebElement> colData = departelement.findElements(By.tagName("th"));
			colData.get(depart).click();
			Reporter.addStepLog("Selecting " + retu +"Flight");
			WebElement Returnelement=returnList.findElement(By.xpath("li["+retu+"]"));
			List<WebElement> retcolData = Returnelement.findElements(By.tagName("th"));
			retcolData.get(retu).click();
	        
		}
		
		
		public java.util.List<String> getSelectedRowData(WebElement listview ,int row) throws Throwable {
	        
			
			WebElement element=listview.findElement(By.xpath("li["+row+"]"));
	        java.util.List<String> flightData = new ArrayList<String>();
	        List<WebElement> colData = element.findElements(By.tagName("th"));
	        System.out.println("table column size:" + colData.size());
	        Reporter.addStepLog("Flight Details");
	        flightData.add(colData.get(1).findElement(By.cssSelector("img")).getAttribute("title"));
	        Reporter.addStepLog(colData.get(1).getAttribute("class")+":" + colData.get(1).findElement(By.cssSelector("img")).getAttribute("title"));
	        for (int i = 2; i < colData.size(); i++) {
	            String str = colData.get(i).getText();
	            Reporter.addStepLog(colData.get(i).getAttribute("class")+":" + str);
	            System.out.println(colData.get(i).getAttribute("class")+":" + str);
	            flightData.add(str);
	        }

	        return flightData;

	    }



}
