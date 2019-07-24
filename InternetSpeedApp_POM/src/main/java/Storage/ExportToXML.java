package Storage;

import ProjectSetup.RepositoryProperties;
import SpeedTestNet_POM.SpeedTestNet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ProjectSetup.BrowserFactory.driver;

public class ExportToXML
{
    PathExist pathExist = new PathExist();
    RepositoryProperties repo = new RepositoryProperties();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String path = repo.EnvProperties("projectPath") + "XMLResults\\";

    public void writeProductXML()
    {
        SpeedTestNet speed = PageFactory.initElements(driver, SpeedTestNet.class);
        pathExist.checkFileDir(path);
        String xmlName = path + "Results " + dateFormat.format(date) + date.getTime() + ".xml";

        String pingValue = speed.readPingValue();
        String downloadValue = speed.readDownloadSpeed();
        String uploadValue = speed.readUploadSpeed();
        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument = documentBuilder.newDocument();

            //Create xml root element
            Element rootElement = xmlDocument.createElement("SpeedValues");
            xmlDocument.appendChild(rootElement);

            //Create root child element
            Element mainElement = xmlDocument.createElement("SpeedValue");
            rootElement.appendChild(mainElement);

            //Creating Ping attribute
            Element ping = xmlDocument.createElement("ping");
            ping.appendChild(xmlDocument.createTextNode(pingValue));
            mainElement.appendChild(ping);

            //Create download attribute
            Element download = xmlDocument.createElement("download");
            download.appendChild(xmlDocument.createTextNode(downloadValue));
            mainElement.appendChild(download);

            //Create upload attribute
            Element upload = xmlDocument.createElement("upload");
            upload.appendChild(xmlDocument.createTextNode(uploadValue));
            mainElement.appendChild(upload);

            //Creating the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(xmlDocument);
            StreamResult streamResult = new StreamResult(new File(xmlName));
            transformer.transform(domSource, streamResult);
        }
        catch(ParserConfigurationException p)
        {
            p.printStackTrace();
        }
        catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        } catch (TransformerException t)
        {
            t.printStackTrace();
        }
    }
}
