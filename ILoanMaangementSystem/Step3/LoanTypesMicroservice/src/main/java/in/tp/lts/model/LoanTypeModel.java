package in.tp.lts.model;

import org.springframework.beans.factory.annotation.Value;

public class LoanTypeModel {

	private int port;
	
	private long id;
	private String typeTitle;
	private double interestRatePerAnum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeTitle() {
		return typeTitle;
	}

	public void setTypeTitle(String typeTitle) {
		this.typeTitle = typeTitle;
	}

	public double getInterestRatePerAnum() {
		return interestRatePerAnum;
	}

	public void setInterestRatePerAnum(double interestRatePerAnum) {
		this.interestRatePerAnum = interestRatePerAnum;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
