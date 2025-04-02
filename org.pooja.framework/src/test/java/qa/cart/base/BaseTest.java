package qa.cart.base;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import qa.PlaywrightFactory.PlaywrightFactory;
import qa.cart.pages.HomePage;
import qa.cart.pages.LoginPage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected HomePage homepage;
	protected LoginPage loginpage;
	protected Properties prop;
	
	
	@BeforeTest
	public void setup() throws FileNotFoundException {
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.init_browser(prop);
		homepage=new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	

}
