package Storage;

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
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private CSVWriter csvWriter;
    private String csvName = "C:\\Users\\Siya\\IdeaProjects\\InternetSpeedApp_POM\\SpeedResults\\SpeetTestValues " + dateFormat.format(date) + " " + date.getTime() + ".csv";

    public void writeToCSV() throws IOException {
        SpeedTestNet speedtestNet = PageFactory.initElements(driver, SpeedTestNet.class);

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
