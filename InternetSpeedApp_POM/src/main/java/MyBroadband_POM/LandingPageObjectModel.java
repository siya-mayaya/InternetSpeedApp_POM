package MyBroadband_POM;

import ProjectSetup.FindUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPageObjectModel
{
    FindUrl findUrl = new FindUrl();

    private String url = findUrl.ChooseBrowser();

    private WebDriver driver;

    @FindBy(how = How.ID, using = "start")
    private WebElement startBtn;

    @FindBy(how = How.ID, using = "ping")
    private WebElement pingValue;

    @FindBy(how = How.ID, using = "download")
    private WebElement downloadValue;

    @FindBy(how = How.ID, using = "upload")
    private WebElement uploadValue;

    public void clickStartBtn()
    {
        startBtn.click();
    }

    public void pingValue()
    {
        pingValue.getText();
    }

    public void downloadValue()
    {
        downloadValue.getText();
    }

    public void upLoadValue()
    {
        uploadValue.getText();
    }
}
