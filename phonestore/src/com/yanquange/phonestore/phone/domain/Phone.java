package com.yanquange.phonestore.phone.domain;

import com.yanquange.phonestore.category.domain.Category;

public class Phone {
	private String pid;
	private String pname;
	private double price;
	private String producer;
	private String image;
	private Category category;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Phone [pid=" + pid + ", pname=" + pname + ", price=" + price
				+ ", producer=" + producer + ", image=" + image + "]";
	}
	
	
}
