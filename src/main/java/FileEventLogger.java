import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by abugaev on 04.01.2018.
 */
public class FileEventLogger implements eventLogger {
    private String filename;
    private File file;

    public FileEventLogger() {
    }

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init()throws IOException{
        this.file=new File(filename);
        if(!file.canWrite()) throw new IOException();
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(file, event.toString()+"\r\n","UTF-8", true);
        }
        catch (IOException e) {
            System.out.println("Something wrong with your file");
        }
    }
}
