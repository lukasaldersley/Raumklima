package Raumklima;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.nio.channels.*;
public class TEST
{
    private int VERSION=1;
    BufferedReader br;
    public TEST()
    {
    }
    
    public boolean checkIfUpdateAvailable(){
        try{
            URL website = new URL("https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/Release/VERSION");
            br=new  BufferedReader(new InputStreamReader(website.openStream()));
            if(Integer.parseInt(br.readLine())>VERSION){
            	return true;
            }
            else{
            	return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
