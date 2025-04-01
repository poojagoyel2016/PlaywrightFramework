package qa.PlaywrightFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Browser browser;
	Playwright pw;
	BrowserContext con;
	Page page;
	
	public Page init_browser(String browserName) {
		
		pw= Playwright.create();
		
		
		switch (browserName.toLowerCase()) {
			case "chrome":
				 browser= pw.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
				 break;
			case "msedge":	
				 browser= pw.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
				 break;
			case "firefox":	
				 browser= pw.firefox().launch(new LaunchOptions().setHeadless(false));
				 break;
			case "safari":
				 browser= pw.webkit().launch(new LaunchOptions().setHeadless(false));
				 break;
			default:
				System.out.println("Wrong browsername");
				break;
	}
				con=browser.newContext();
				page=con.newPage();
				page.navigate("https://naveenautomationlabs.com/opencart/");
				return page;
				
				 
				 
	}
}
