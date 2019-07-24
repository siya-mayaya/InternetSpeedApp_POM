package Storage;

import ProjectSetup.RepositoryProperties;
import SpeedTestNet_POM.SpeedTestNet;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ProjectSetup.BrowserFactory.driver;

public class ExportToJson
{
    PathExist pathExist = new PathExist();
    RepositoryProperties repo = new RepositoryProperties();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String path = repo.EnvProperties("projectPath") + "JsonResults\\";


    public void writeToJson()
    {
        SpeedTestNet speed = PageFactory.initElements(driver, SpeedTestNet.class);

        pathExist.checkFileDir(path);
        String jsonName = path + "Results " + dateFormat.format(date) + date.getTime() + ".json";

        JSONObject speedDetails = new JSONObject();
        speedDetails.put("ping", speed.readPingValue());
        speedDetails.put("download", speed.readDownloadSpeed());
        speedDetails.put("upload", speed.readUploadSpeed());

        JSONObject speedDetailObject = new JSONObject();
        speedDetailObject.put("Internet Speed", speedDetails);

        try(FileWriter file = new FileWriter(jsonName))
        {
            file.write(speedDetailObject.toJSONString());
            file.flush();
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
    }
}
