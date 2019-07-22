package ProjectSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RepositoryProperties
{
    private String stringValueOfProperetiesFile;
    private FileInputStream input;
    private String location = "C:\\Users\\Siya\\IdeaProjects\\InternetSpeedApp_POM\\src\\main\\resources\\Repository\\FileRepository.properties";
    private Properties property = new Properties();

    public String EnvProperties(String stringParsedIn)
    {
        try
        {
            input = new FileInputStream(location);
            property.load(input);
            this.stringValueOfProperetiesFile = property.getProperty(stringParsedIn);
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
        return stringValueOfProperetiesFile;
    }
}
