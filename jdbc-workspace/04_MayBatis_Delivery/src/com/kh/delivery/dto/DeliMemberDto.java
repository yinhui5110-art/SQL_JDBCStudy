package com.kh.delivery.dto;

import java.sql.Date;

public class DeliMemberDto {
	private int member_No;
	private String member_Id;
	private String member_Pw;
	private String member_Name;
	private String address;
	private Date enroll_Date;

	public DeliMemberDto() {}
	public DeliMemberDto(String member_Id, String member_Pw, String member_Name, String address) {
		this.member_Id = member_Id;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.address = address;
	}
	public DeliMemberDto(int member_No, String member_Id, String member_Pw, String member_Name, String address,
			Date enroll_Date) {
		this.member_No = member_No;
		this.member_Id = member_Id;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.address = address;
		this.enroll_Date = enroll_Date;
	}
	public int getMember_No() {
		return member_No;
	}
	public void setMember_No(int member_No) {
		this.member_No = member_No;
	}
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	public String getMember_Pw() {
		return member_Pw;
	}
	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}
	public String getMember_Name() {
		return member_Name;
	}
	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEnroll_Date() {
		return enroll_Date;
	}
	public void setEnroll_Date(Date enroll_Date) {
		this.enroll_Date = enroll_Date;
	}
	@Override
	public String toString() {
		return "DeliMemberDto [member_No=" + member_No + ", member_Id=" + member_Id + ", member_Pw=" + member_Pw
				+ ", member_Name=" + member_Name + ", address=" + address + ", enroll_Date=" + enroll_Date + "]";
	}
	

}
