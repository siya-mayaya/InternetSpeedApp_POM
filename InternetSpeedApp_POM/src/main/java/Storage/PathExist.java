package Storage;

import java.io.File;

public class PathExist
{
    public void checkFileDir(String filePath)
    {
        File pathFolder = new File(filePath);

        if(!pathFolder.exists())
        {
            pathFolder.mkdir();
        }
    }
}
