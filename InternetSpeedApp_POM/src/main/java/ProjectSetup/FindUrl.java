package ProjectSetup;

import java.util.Scanner;

public class FindUrl
{

    public static String ChooseBrowser()
    {
        Scanner scanner = new Scanner(System.in);

        RepositoryProperties property = new RepositoryProperties();

        String url = null;

        System.out.println("Choose option: \n1. SpeedTestNet \n2. My Broadband");

        int option = scanner.nextInt();

        if(option == 1)
        {
            url = property.EnvProperties("speedtestneturl");
        }
        else if (option == 2)
        {
            url = property.EnvProperties("mybroadbandurl");
        }
        else
        {
            System.out.println("Invalid option");
        }
        return url;
    }
}
