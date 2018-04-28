package com.yanquange.phonestore.cate.domain;

import java.awt.print.Book;
import java.math.BigDecimal;

import com.yanquange.phonestore.phone.domain.Phone;



public class CartItem {
	private Phone phone;
	private int count;


	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public double getSubtatal(){
		BigDecimal d1 = new BigDecimal(phone.getPrice()+"");
		BigDecimal d2 = new BigDecimal(count+"");
		
		return d1.multiply(d2).doubleValue();
	}

}
