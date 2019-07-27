package Database;

public class testSQL
{
    public static void main(String[] args)
    {
        RetrieveResults results = new RetrieveResults();
        InsertIntoDatabase insertIntoDatabase = new InsertIntoDatabase();
        insertIntoDatabase.InsertIntoDatabase();
        //results.readDatabase();
    }
}
