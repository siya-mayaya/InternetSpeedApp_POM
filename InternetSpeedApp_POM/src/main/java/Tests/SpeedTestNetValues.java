package Tests;

import ProjectSetup.BrowserFactory;
import ProjectSetup.ProgramWait;
import SpeedTestNet_POM.SpeedTestNet;
import Storage.ExportToCSV;
import Storage.ExportToJson;
import Storage.ExportToXML;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SpeedTestNetValues
{
    private ExportToCSV exp = new ExportToCSV();
    private ExportToXML xml = new ExportToXML();
    private ExportToJson jsn = new ExportToJson();
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
        System.out.println(speedTestNet.readUploadSpeed());
    }

    @AfterTest
    public void export() throws Exception
    {
        exp.writeToCSV();
        xml.writeProductXML();
        jsn.writeToJson();
    }
}
