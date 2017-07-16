package com.example.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Tranche implements Externalizable{

	private String trancheId;
	private String trancheName;
	
	public Tranche() {
		super();
	}

	public Tranche(String trancheId, String trancheName) {
		super();
		this.trancheId = trancheId;
		this.trancheName = trancheName;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Tranche writeExternal method call..");
		out.writeObject(this.trancheId);
		out.writeObject(this.trancheName);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Tranche readExternal method call..");
		this.trancheId = (String)in.readObject();
		this.trancheName = (String)in.readObject();
	}

	public String getTrancheId() {
		return trancheId;
	}

	public void setTrancheId(String trancheId) {
		this.trancheId = trancheId;
	}

	public String getTrancheName() {
		return trancheName;
	}

	public void setTrancheName(String trancheName) {
		this.trancheName = trancheName;
	}

	@Override
	public String toString() {
		return "Tranche [trancheId=" + trancheId + ", trancheName="
				+ trancheName + "]";
	}
}
