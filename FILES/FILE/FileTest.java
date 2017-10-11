package FILE;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileTest//https://stackoverflow.com/questions/15654154/access-pdf-file-from-within-my-jar
//Antwort von Ankit angepasst
//auch in /FILE/stackoverflow.com_questions_15654154_access-pdf-file-from-within-my-jar.htm aufgerufen am 10.10.2017 um 23:20 Uhr
{
    public static void main(String[] args) {
    	new FileTest();
    }
    
    public FileTest(){
        try {
            InputStream is = this.getClass().getResourceAsStream("/FILE/PDF_DATEI.pdf");
            byte[] data = new byte[is.available()];
            is.read(data);
            is.close();
            String tempFile = "PDF_DATEI";
            File temp = File.createTempFile(tempFile, ".pdf");
            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(data);
            fos.flush();
            fos.close();
            Desktop.getDesktop().open(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
