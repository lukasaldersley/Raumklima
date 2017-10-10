import java.io.IOException;
import com.fazecast.jSerialComm.*;
public class Uploader{
/*    A command line looks like this in a stock Arduino IDE:
    D:\arduino-dev\arduino-1.0.3\hardware/tools/avr/bin/avrdude
    -CD:\arduino-dev\arduino-1.0.3\hardware/tools/avr/etc/avrdude.conf
    -v -v -v -v -patmega328p -carduino     -P\\.\COM8 -b115200 -D -V
    -Uflash:w:e:\Temp\build100458372319682483.tmp\Blink.cpp.hex:i
    Just write the binary to the .HEX file and let the dude upload it:     */
    final String ARDUINO_UNO="-patmega328p";
    final String ARDUINO_MEGA_2560="-pm2560";
    final String ARDUINO_LEONARDO="-patmega32u4";
    final String ARDUINO_PRO_MINI=ARDUINO_UNO;
    String hexfile;//"e:\somefolder\Blink.cpp.hex";
    String exefile = "D:\\arduino-dev\\arduino-1.0.3\\hardware/tools/avr/bin/avrdude";
    String conffile = "D:\\arduino-dev\\arduino-1.0.3\\hardware/tools/avr/etc/avrdude.conf";
    String opts1 = " -v -v -v -v ";
    String opts2=" -carduino -P\\\\.\\";
    String opts3=" -b115200 -D -V ";
    String opts;
    SerialPort[] ports;
    SerialPort port;
    public int upload(String hexfile) throws InterruptedException, IOException{
    String cmd = exefile +" -C"+ conffile + opts +" -Uflash:w:" + hexfile +":i";
    Process proc = Runtime.getRuntime().exec(cmd);
    int retcode = proc.waitFor();
    return retcode;
    }
    public void prepare(String boardModel,String comPort){
    opts="";
    if(comPort.contains("|")){
    comPort=comPort.substring(0,comPort.indexOf("|"));
    }
    opts=opts1+boardModel+opts2+comPort+opts3;
    System.out.println(opts);
    }
    public String[] getPorts(){
    ports=SerialPort.getCommPorts();
    String[] ret=new String[ports.length];
    for(int i=0;i<ret.length;i++){
    ret[i]=ports[i].getSystemPortName()+"|"+ports[i].getDescriptivePortName();
    }
    if(ret.length==0){
    ret=new String[1];
    ret[0]="Nicht verfügbar";
    }
    return ret;
    }
    }
