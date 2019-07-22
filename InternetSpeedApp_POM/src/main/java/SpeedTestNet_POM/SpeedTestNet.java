package SpeedTestNet_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SpeedTestNet
{
    WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "start-text")
    private WebElement GoBTN;

    @FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[3]/div/div[1]/div[2]/div[1]/div/div[2]/span")
    private WebElement pingValue;

    @FindBy(how = How.XPATH, using  = "//*[@id=\"container\"]/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[3]/div/div[1]/div[2]/div[2]/div/div[2]/span")
    private WebElement downloadSpeed;

    @FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div[2]/div/div/div/div[3]/div[1]/div[3]/div/div[3]/div/div[1]/div[2]/div[3]/div/div[2]/span")
    private WebElement uploadSpeed;


    public SpeedTestNet(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickGoBTN()
    {
        GoBTN.click();
    }

    public String readPingValue()
    {
        return pingValue.getText();
    }

    public String readDownloadSpeed()
    {
        return downloadSpeed.getText();
    }

    public String readUploadSpeed()
    {
        return uploadSpeed.getText();
    }
}
