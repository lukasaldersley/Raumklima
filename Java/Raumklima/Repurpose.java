package SCHULE.W_SEMINAR;
import java.io.*;
public class Repurpose
{
    BufferedReader br;
    String zeile;
    String name="F:\\CODE\\JAVA\\LOG.CSV";
    String name1="F:\\CODE\\JAVA\\LOG_OK.CSV";
    private FileWriter writer;
    private File file;
    long counter=0;
    
    public Repurpose(){
        try{
            br = new BufferedReader(new FileReader(name));
            br.readLine();
            zeile=br.readLine();
            while(zeile!=null||zeile!=""){
                zeile.replace(zeile.charAt(8),'.');
                String[] arr=zeile.split(";");
                String zwsp="";
                //System.out.println(arr[3]);
                for(int i=0;i<arr[3].length();i++){
                	if(arr[3].charAt(i)==','){
                		zwsp+=".";
                	}
                	else{
                		zwsp+=String.valueOf(arr[3].charAt(i));
                	}
                }
                arr[3]=zwsp;
                //System.out.println(arr[3]);
                arr[3]=String.valueOf((Double.parseDouble(arr[3]))-7.44);
                zeile=arr[0]+";"+arr[1]+";"+arr[2]+";"+arr[3]+";"+arr[4]+";"+arr[5]+";"+arr[6];
                zeile.replace('.',',');
                log(zeile,name1);
                System.out.println("\t\t\t"+zeile);
                System.out.println(counter++);
                arr=null;
                zwsp=null;
                zeile=br.readLine();
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void log(String inhalt,String fileName) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file,true);//true damit an die bestehende datei angegängt wird, sonst würde Sie überschrieben
            writer.write(inhalt);
            writer.flush();
            writer.close();
            ln(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args){
    	new Repurpose();
    }

    public void ln(String fileName) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file,true);//true damit an die bestehende datei angegängt wird, sonst würde Sie überschrieben
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
