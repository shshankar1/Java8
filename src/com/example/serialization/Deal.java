package com.example.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Deal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String dealId;
	private String dealName;
	
	public Deal(String dealId, String dealName) {
		super();
		this.dealId = dealId;
		this.dealName = dealName;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out.println("Deal class writeObject..");
		oos.writeObject(this.dealId);
		oos.writeObject(this.dealName);
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		System.out.println("Deal class readObject..");
		this.dealId = (String)ois.readObject();
		this.dealName = (String)ois.readObject();
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	@Override
	public String toString() {
		return "Deal [dealId=" + dealId + ", dealName=" + dealName + "]";
	}
	
	
}
