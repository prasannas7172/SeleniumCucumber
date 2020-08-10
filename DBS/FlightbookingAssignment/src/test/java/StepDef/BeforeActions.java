package StepDef;
import cucumber.api.java.Before;

import org.testng.annotations.Parameters;

import com.Trip.utlity.SeleniumDriver;

public class BeforeActions  {
	
		
	@Before("@Chrome")
	public void setUpChrome() {
		System.out.println("Before");
		  SeleniumDriver.setUpDriver("Chrome");
	}	

	
	  @Before("@Firefox")
	  public void setUpFirefox() {
	  System.out.println("Before");
	  SeleniumDriver.setUpDriver("Firefox"); 
	  }
	 
	
		
		/*System.out.println("Before");
        SeleniumDriver.setUpDriver();*/
		/* } */
}
