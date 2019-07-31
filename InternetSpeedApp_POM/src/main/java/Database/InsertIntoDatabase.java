package Database;

import SpeedTestNet_POM.SpeedTestNet;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.openqa.selenium.support.PageFactory;

import java.sql.*;

import static ProjectSetup.BrowserFactory.driver;

public class InsertIntoDatabase
{
    String empty = null;
    ResultSet rs = null;
    int Id;
    String sqlStmt = "insert into speedtest.speedresults (ping, download, upload) VALUES (?, ?, ?)";

    public void InsertIntoDatabase()
    {
        SpeedTestNet speed = PageFactory.initElements(driver, SpeedTestNet.class);

        String ping = speed.readPingValue();
        String download = speed.readDownloadSpeed();
        String upload = speed.readUploadSpeed();

        try
        {
            Connection con = JConection.ConnectToDb();
            PreparedStatement prep = con.prepareStatement(sqlStmt);

            prep.setString(1, ping);
            prep.setString(2, download);
            prep.setString(3, upload);

            prep.execute();
        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }

    }
}
