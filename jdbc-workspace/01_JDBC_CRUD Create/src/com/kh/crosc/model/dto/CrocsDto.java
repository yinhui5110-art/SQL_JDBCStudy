package com.kh.crosc.model.dto;

public class CrocsDto {
	private String crocs_Id;
	private String crocs_Pwd;
	private String crocs_NickName;
	public CrocsDto() {}
	public CrocsDto(String crocs_Id, String crocs_Pwd, String crocs_NickName) {
		this.crocs_Id = crocs_Id;
		this.crocs_Pwd = crocs_Pwd;
		this.crocs_NickName = crocs_NickName;
	}
	public String getCrocs_Id() {
		return crocs_Id;
	}
	public void setCrocs_Id(String crocs_Id) {
		this.crocs_Id = crocs_Id;
	}
	public String getCrocs_Pwd() {
		return crocs_Pwd;
	}
	public void setCrocs_Pwd(String crocs_Pwd) {
		this.crocs_Pwd = crocs_Pwd;
	}
	public String getCrocs_NickName() {
		return crocs_NickName;
	}
	public void setCrocs_NickName(String crocs_NickName) {
		this.crocs_NickName = crocs_NickName;
	}
	@Override
	public String toString() {
		return "CrocsDto [crocs_Id=" + crocs_Id + ", crocs_Pwd=" + crocs_Pwd + ", crocs_NickName=" + crocs_NickName
				+ "]";
	}
		

	
}
