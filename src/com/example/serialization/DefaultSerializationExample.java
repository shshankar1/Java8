package com.example.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DefaultSerializationExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("D:\\temp.ser");
		
		Student s1 = new Student("1","Shashi");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		
		Student s2 = new Student("2","Shankar");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos);
		oos1.writeObject(s2);
		
		fos.close();
		FileInputStream fis = new FileInputStream("D:\\temp.ser");
				
		boolean readfurther=true;
		try{
			while(readfurther){
				ObjectInputStream ois = new ObjectInputStream(fis);
				Student s = (Student)ois.readObject();
				System.out.println(s.toString());
			}
			fis.close();
		}catch(EOFException e){
			
		}
		
		
	}

}
