package ProjectSetup;

public class ProgramWait
{
    public void waitForTestToLoad()
    {
        try
        {
            Thread.sleep(40000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
