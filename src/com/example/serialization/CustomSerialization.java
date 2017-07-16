package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("D:\\temp.ser");
		
		Deal d1 = new Deal("1224","NWOODS10");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		fos.close();
		FileInputStream fis = new FileInputStream("D:\\temp.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Deal temp = (Deal)ois.readObject();
		System.out.println(temp);
		fis.close();
	}

}
