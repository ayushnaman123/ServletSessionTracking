package in.coder.dto;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String pName;
	private Integer pCost;
	private String pBrand;
	private Integer pQuantity;
	private String pCategory;
	private String pManufacturer;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getpCost() {
		return pCost;
	}
	public void setpCost(Integer pCost) {
		this.pCost = pCost;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public Integer getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public String getpManufacturer() {
		return pManufacturer;
	}
	public void setpManufacturer(String pManufacturer) {
		this.pManufacturer = pManufacturer;
	}
	@Override
	public String toString() {
		return "Product [pName=" + pName + ", pCost=" + pCost + ", pBrand=" + pBrand + ", pQuantity=" + pQuantity
				+ ", pCategory=" + pCategory + ", pManufacturer=" + pManufacturer + "]";
	}
	
	
}
