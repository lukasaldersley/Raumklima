package SCHULE.W_SEMINAR;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FILE {
	static FileWriter writer;
	static File file;
	
	
	//WRITING IN VARIATIONS
	public static void WRITE(String loc, String cont){
		if(cont.equals("#LINE")){
			ln(loc);
		}
		else{
			log1(loc,cont);
		}
	}
	
	public static void WRITE(String loc, String cont, boolean add){
		if(cont.equals("#LINE")){
			ln(loc,add);
		}
		else{
			log1(loc,cont,add);
		}
	}
	
	public static void WRITELN(String loc, String cont){
		if(cont.equals("#LINE")){
			ln(loc);
		}
		else{
			log(loc,cont);
		}
	}
	
	public static void WRITELN(String loc, String cont, boolean add){
		if(cont.equals("#LINE")){
			ln(loc,add);
		}
		else{
			log(loc,cont,add);
		}
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
	
	private static void log1(String fileName, String inhalt, boolean add) {
		file = new File(fileName);
		try {
			writer = new FileWriter(file,add);
			writer.write(inhalt);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void log(String fileName, String inhalt) {
		file = new File(fileName);
		try {
			writer = new FileWriter(file);
			writer.write(inhalt);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void log1(String fileName, String inhalt) {
		file = new File(fileName);
		try {
			writer = new FileWriter(file);
			writer.write(inhalt);
			writer.flush();
			writer.close();
			ln(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ln(String fileName) {
		file = new File(fileName);
		try {
			writer = new FileWriter(file);
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
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
	//END OF WRITING METHODS
	
	
	
	//READING METHODS
	
	//END OF READING MTHODS
}