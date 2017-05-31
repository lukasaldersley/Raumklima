package serialIO.IO.DISK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FILE {
    static FileWriter writer;
    static File file;

    public static void WRITE(String loc, String cont, boolean add){
        log(loc,cont,add);
    }

    private static void log(String fileName, String inhalt, boolean add) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file,add);
            writer.write(inhalt);
            writer.flush();
            writer.close();
            ln(fileName,add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ln(String fileName,boolean add) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file, add);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
