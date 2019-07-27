package ProjectSetup;

public class FindUrl
{
    public static String ChooseBrowser()
    {
        RepositoryProperties property = new RepositoryProperties();

        String url = null;

        String option = property.EnvProperties("option");

        switch(option)
        {
            case "1": url = property.EnvProperties("speedtestneturl");
            break;

            case "2": url = property.EnvProperties("mybroadbandurl");
            break;
        }
        return url;
    }
}