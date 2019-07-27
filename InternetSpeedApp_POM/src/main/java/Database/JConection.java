package Database;

import ProjectSetup.RepositoryProperties;

import java.sql.*;

public class JConection
{
    private static RepositoryProperties repo = new RepositoryProperties();
    private static final String username = repo.EnvProperties("dbuser");
    private static final String password = repo.EnvProperties("dbpassword");
    private static final String conn = repo.EnvProperties("dbconn");


    public static Connection ConnectToDb() throws SQLException
    {
            return DriverManager.getConnection(conn, username, password);
    }
}
