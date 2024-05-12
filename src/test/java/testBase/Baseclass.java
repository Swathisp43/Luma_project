package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Baseclass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = {"regression", "sanity", "master"})
	@Parameters({"os", "browser"})
	public void Setup(String os, String br) throws IOException {
		
		//Loading config files
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		//Loading log4j files
		logger = LogManager.getLogger(this.getClass());  //Log4j
		
		//Launching browser based on condition
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver();  break;
		case "edge" : driver = new EdgeDriver();  break;
		default : System.out.println("No matching browser");
		return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();	
	}
	@AfterClass (groups = {"regression", "sanity", "master"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomnumber() {
		String generatedstring = RandomStringUtils.randomNumeric(8);
		return generatedstring;
	}
	public String randomalphanumeric() {
		String string = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(8);
		return(string+ "@" + num);
		
	}

}
