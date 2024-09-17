package in.coder.dto;

import java.io.Serializable;

public class Students implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String sName;
	private Integer sAge;
	private String sQualification;
	private String sDesignation;
	private String sEmail;
	private String sMobile;
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsAge() {
		return sAge;
	}
	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}
	public String getsQualification() {
		return sQualification;
	}
	public void setsQualification(String sQualification) {
		this.sQualification = sQualification;
	}
	public String getsDesignation() {
		return sDesignation;
	}
	public void setsDesignation(String sDesignation) {
		this.sDesignation = sDesignation;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsMobile() {
		return sMobile;
	}
	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}
	
	@Override
	public String toString() {
		return "Students [sName=" + sName + ", sAge=" + sAge + ", sQualification=" + sQualification + ", sDesignation="
				+ sDesignation + ", sEmail=" + sEmail + ", sMobile=" + sMobile + "]";
	}
	
	

}
