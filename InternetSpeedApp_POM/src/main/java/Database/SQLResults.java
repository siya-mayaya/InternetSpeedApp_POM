package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLResults
{
    public static void getSpeed(ResultSet rs) throws SQLException
    {
        while(rs.next())
        {
            StringBuffer buffer = new StringBuffer();

            buffer.append("Id: " + rs.getInt("Id") + "\n");
            buffer.append("Ping: " + rs.getString("ping") + "\n");
            buffer.append("Download: " + rs.getString("download") + "\n");
            buffer.append("Upload: " + rs.getString("upload"));

            System.out.println(buffer.toString());
        }
    }
}
