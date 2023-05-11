package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumUtils {
    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;

        switch (getBrowserEnumString(browserType)){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
            case MOZILLA:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
        }
        return driver;
    }

    public static Browsers getBrowserEnumString(String browserType){
        for(Browsers browser: Browsers.values()){
            if(browserType.equalsIgnoreCase(browser.toString())){
                return browser;
            }
        }
        return null;
    }

    public static Properties readProprieties(String path) throws IOException{
        InputStream inputStream = new FileInputStream(path);
        Properties proprieties = new Properties();
        proprieties.load(inputStream);

        return proprieties;
    }
}
