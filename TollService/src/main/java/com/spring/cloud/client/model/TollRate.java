package com.spring.cloud.client.model;

import java.math.BigDecimal;

public class TollRate {

	private int stationId;
	private BigDecimal currentRate;
	private String timeStamp;
	
	public TollRate(int stationId, BigDecimal currentRate, String timeStamp) {
		this.stationId = stationId;
		this.currentRate = currentRate;
		this.timeStamp = timeStamp;
	}
	
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public BigDecimal getCurrentRate() {
		return currentRate;
	}
	public void setCurrentRate(BigDecimal currentRate) {
		this.currentRate = currentRate;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
