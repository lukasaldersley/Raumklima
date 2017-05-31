package SCHULE.W_SEMINAR;
import serialIO.IO.DISK.FILE;
public class CSV
{
    public CSV()
    {
    }

    void println(String msg){
        FILE.WRITE("SensorData["+System.currentTimeMillis()+"].csv",msg,true);
    }
}
