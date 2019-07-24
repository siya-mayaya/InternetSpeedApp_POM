package Storage;

import ProjectSetup.RepositoryProperties;
import SpeedTestNet_POM.SpeedTestNet;
import com.opencsv.CSVWriter;
import org.openqa.selenium.support.PageFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ProjectSetup.BrowserFactory.driver;

public class ExportToCSV
{
    PathExist pathExist = new PathExist();
    RepositoryProperties repo = new RepositoryProperties();
    private String path = repo.EnvProperties("projectPath") + "SpeedResults\\";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private CSVWriter csvWriter;


    public void writeToCSV() throws IOException
    {
        SpeedTestNet speedtestNet = PageFactory.initElements(driver, SpeedTestNet.class);
        pathExist.checkFileDir(path);
        String csvName = path + "SpeetTestValues " + dateFormat.format(date) + " " + date.getTime() + ".csv";

        String[] value =
                {
                        speedtestNet.readPingValue(),
                        speedtestNet.readDownloadSpeed(),
                        speedtestNet.readUploadSpeed()
                };

        try
        {
            csvWriter = new CSVWriter(new FileWriter(csvName));
            csvWriter.writeNext(value);
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }

        finally
        {
            csvWriter.flush();
            csvWriter.close();
        }
    }
}
