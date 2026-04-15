package com.kh.keeper.model.dto;

import java.sql.Date;

public class KeeperDto {
	// 제약조건, 인서트시점에 사용자에게 무슨 값을 받을 것인지 생각해야한다
	private String keeperId;
	private String keeperName;
	private Date hireDate;
	private String zoneId;
	//private String date; 기존클래스를 수정하는 것은 위험할 수 있기때문에 
	//상속클래스를 따로 만들어도 된다.
	
	public KeeperDto(String keeperId, String keeperName, Date hireDate, String zoneId) {
		this.keeperId = keeperId;
		this.keeperName = keeperName;
		this.hireDate = hireDate;
		this.zoneId = zoneId;
	}
	public KeeperDto() {
	}
	public KeeperDto(String keeperName, String zoneId) {
		this.keeperName = keeperName;
		this.zoneId = zoneId;
	}
	public String getKeeperId() {
		return keeperId;
	}
	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}
	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	@Override
	public String toString() {
		return "KeeperDto [keeperId=" + keeperId + ", keeperName=" + keeperName + ", hireDate=" + hireDate + ", zoneId="
				+ zoneId + "]";
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

	
	}

	
	


