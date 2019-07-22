package ProjectSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory extends RepositoryProperties
{
    public static WebDriver driver;

    public static WebDriver startBrowser(String BrowserName)
    {
        RepositoryProperties property = new RepositoryProperties();
        FindUrl findUrl = new FindUrl();
        String Url = findUrl.ChooseBrowser();

        String chromeProperties = property.EnvProperties("chromepath");
        String chromeDriverPath = property.EnvProperties("chromedriver");

        String browser = BrowserName.toLowerCase();

        switch(browser)
        {
            case "chrome":
                System.setProperty(chromeProperties, chromeDriverPath);
                driver = new ChromeDriver();

            case "firefox":
                driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(Url);
        return driver;
    }
}

