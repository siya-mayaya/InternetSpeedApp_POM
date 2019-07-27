package Database;

import SpeedTestNet_POM.SpeedTestNet;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.openqa.selenium.support.PageFactory;

import java.sql.*;

import static ProjectSetup.BrowserFactory.driver;

public class InsertIntoDatabase
{
    ResultSet rs = null;
    int Id;
    String sqlStmt = "insert into speedtest.speedresults (Id, ping, download, upload) VALUES (?, ?, ?, ?)";

    public void InsertIntoDatabase()
    {
        SpeedTestNet speed = PageFactory.initElements(driver, SpeedTestNet.class);

        String ping = speed.readPingValue();
        String download = speed.readDownloadSpeed();
        String upload = speed.readUploadSpeed();
/*
        String ping = "29";
        String download = "19.65";
        String upload = "15.20";
*/
        try
        {
            Connection con = JConection.ConnectToDb();
            PreparedStatement prep = con.prepareStatement(sqlStmt);
                try
                {
                    Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    rs = smt.executeQuery("SELECT Id FROM speedtest.speedresults");
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }


            rs.last();
            Id = rs.getInt("Id");
            Id++;
            String ID = Integer.toString(Id);
            prep.setString(1, ID);
            prep.setString(2, ping);
            prep.setString(3, download);
            prep.setString(4, upload);

            prep.execute();
        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }

    }
}
