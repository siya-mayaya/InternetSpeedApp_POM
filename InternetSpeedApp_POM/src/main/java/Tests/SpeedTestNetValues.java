package Tests;

import ProjectSetup.BrowserFactory;
import ProjectSetup.ProgramWait;
import SpeedTestNet_POM.SpeedTestNet;
import Storage.ExportToCSV;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SpeedTestNetValues
{
    private ExportToCSV exp = new ExportToCSV();
    private WebDriver driver = BrowserFactory.startBrowser("Chrome");
    private SpeedTestNet speedTestNet = PageFactory.initElements(driver, SpeedTestNet.class);
    private ProgramWait wait = new ProgramWait();

    @Test(priority = 1)
    public void clickBtn()
    {
        speedTestNet.clickGoBTN();
    }

    @Test(priority = 2)
    public void pingValue()
    {
        wait.waitForTestToLoad();
        speedTestNet.readPingValue();
    }

    @Test(priority = 3)
    public void downloadValue()
    {
        speedTestNet.readDownloadSpeed();
    }

    @Test(priority = 4)
    public void uploadValue()
    {
        speedTestNet.readUploadSpeed();
    }

    @AfterTest
    public void exportToCSV() throws Exception
    {
        exp.writeToCSV();
//        String[] values =
//                {
//                        speedTestNet.readPingValue(),
//                        speedTestNet.readDownloadSpeed(),
//                        speedTestNet.readUploadSpeed()
//                };
//        return values;
    }
}
