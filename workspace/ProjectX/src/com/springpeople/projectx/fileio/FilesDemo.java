package com.springpeople.projectx.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class FilesDemo {

	public void writeToFile() {
		String path = "E:\\training\\paychex\\sample.txt";
		String data = "This is the line I want to write into the file";
		try {
			FileOutputStream fOut = new FileOutputStream(path);
			byte[] array = data.getBytes();
			fOut.write(array);
			fOut.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readFromFile() {
		String path = "E:\\training\\paychex\\sample.txt";
		
		try {
			FileInputStream fIn = new FileInputStream(path);
			
			byte[] data = fIn.readAllBytes();
			
//			System.out.println(data.toString());
			for(byte b: data) {
				System.out.print((char)b);
			}
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void writeObjectToFile() {
		String path = "E:\\training\\paychex\\objfile.txt";
		Users user = new Users(1, "Prithvi");
		
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(user);
			out.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readObjectFromFile() {
		String path = "E:\\training\\paychex\\objfile.txt";
		
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			Users user = (Users)objIn.readObject();
			System.out.println(user.toString());
			
			objIn.close();
			fileIn.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void charStreamDemo() {
		String data = null;
		String path = "E:\\training\\paychex\\textfile.txt";
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter())
		
		try {
			System.out.println("Enter some data: ");
			data = br.readLine();
			
			FileOutputStream out = new FileOutputStream(path);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			bw.write(data);
			
			bw.close();
			out.close();
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	
	
}
