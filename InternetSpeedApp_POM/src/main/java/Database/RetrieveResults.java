package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveResults
{
    SQLResults sqlResults = new SQLResults();
    ResultSet result = null;

    public ResultSet readDatabase()
    {
        try(
                Connection con = JConection.ConnectToDb();
                Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = smt.executeQuery("SELECT * FROM speedtest.speedresults")
            )
        {
            sqlResults.getSpeed(rs);
            result = rs;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
