package qa.PlaywrightFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Browser browser;
	Playwright pw;
	BrowserContext context;
    Page page;
	Properties prop;
	public static ThreadLocal<Playwright> tlPlaywright=new ThreadLocal<>();
	public static ThreadLocal<Browser> tlbrowser=new ThreadLocal<>();
	public static ThreadLocal<BrowserContext> tlContext=new ThreadLocal<>();
	public static ThreadLocal<Page> tlPage=new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}
	
	public static Browser getBrowser() {
		return tlbrowser.get();
	}
	public static BrowserContext getBrowserContext() {
		return tlContext.get();
	}
	public static Page getPage() {
		return tlPage.get();
	}
	
	
	
	
	public Page init_browser(Properties prop) {
		String browserName=prop.getProperty("browser").trim();
		tlPlaywright.set(Playwright.create());
		
		
		switch (browserName.toLowerCase()) {
			case "chrome":
				// browser= pw.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
				tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false))); 
				break;
			case "msedge":	
				// browser= pw.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
				tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)));
				 break;
			case "firefox":	
				 //browser= pw.firefox().launch(new LaunchOptions().setHeadless(false));
				tlbrowser.set(getPlaywright().firefox().launch(new LaunchOptions().setHeadless(false)));
				 break;
			case "safari":
				 //browser= pw.webkit().launch(new LaunchOptions().setHeadless(false));
				tlbrowser.set(getPlaywright().webkit().launch(new LaunchOptions().setHeadless(false)));
				 break;
			default:
				System.out.println("Wrong browsername");
				break; 
				}
		
				tlContext.set(getBrowser().newContext());
				tlPage.set(getBrowserContext().newPage());
				getPage().navigate(prop.getProperty("url").trim());
				return getPage();
				
				 
				 
	}
	public Properties init_prop() throws FileNotFoundException {
		prop=new Properties();
		FileInputStream fis= new FileInputStream(".\\src\\main\\resources\\config\\config.properties");
		try {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
