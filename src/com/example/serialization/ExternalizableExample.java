package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("D:\\temp.ser");
		
		Tranche t = new Tranche("1","EQUITY");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		fos.close();
		FileInputStream fis = new FileInputStream("D:\\temp.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Tranche temp = (Tranche)ois.readObject();
		System.out.println(temp);
		fis.close();

	}

}
