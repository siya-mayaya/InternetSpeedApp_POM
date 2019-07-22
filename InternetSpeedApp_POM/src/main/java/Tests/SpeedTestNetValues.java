package Tests;

import ProjectSetup.BrowserFactory;
import ProjectSetup.ProgramWait;
import SpeedTestNet_POM.SpeedTestNet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SpeedTestNetValues
{
    private WebDriver driver = BrowserFactory.startBrowser("Chrome");
    private SpeedTestNet speedTestNet = PageFactory.initElements(driver, SpeedTestNet.class);
    private ProgramWait wait = new ProgramWait();

    @Test
    public void clickBtn()
    {
        speedTestNet.clickGoBTN();
    }

    @Test
    public void pingValue()
    {
        wait.waitForTestToLoad();
        speedTestNet.readPingValue();
    }

    @Test
    public void downloadValue()
    {
        speedTestNet.readDownloadSpeed();
    }

    @Test
    public void uploadValue()
    {
        speedTestNet.readUploadSpeed();
    }
}
