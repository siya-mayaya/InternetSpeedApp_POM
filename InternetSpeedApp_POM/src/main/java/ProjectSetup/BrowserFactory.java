package ProjectSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory
{
    public static WebDriver driver;

    public static WebDriver startBrowser(String BrowserName)
    {
        RepositoryProperties property = new RepositoryProperties();
        FindUrl findUrl = new FindUrl();
        String Url = findUrl.ChooseBrowser();

        String browser = BrowserName.toLowerCase();

        switch(browser)
        {
            case "chrome":
                String chromeProperties = property.EnvProperties("chromedriver");
                String chromeDriverPath = property.EnvProperties("chromepath");
                System.setProperty(chromeProperties, chromeDriverPath);
                driver = new ChromeDriver();
                break;

            case "firefox":
                String ffProperties = property.EnvProperties("geckodriver");
                String ffDriverPath = property.EnvProperties("firefoxpath");
                System.setProperty(ffProperties, ffDriverPath);
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get(Url);
        return driver;
    }
}

