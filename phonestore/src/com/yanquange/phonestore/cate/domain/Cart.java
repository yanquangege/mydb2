package com.yanquange.phonestore.cate.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String ,CartItem> map = new LinkedHashMap<String,CartItem>(); 
	public double getTotal(){
		BigDecimal total = new BigDecimal("0");
		for(CartItem cartItem :map.values()){
			BigDecimal subtotal = new BigDecimal(""+cartItem.getSubtatal());
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}
	
	public void add(CartItem cartItem){
		if(map.containsKey(cartItem.getPhone().getPid())){
			CartItem _cartItem = map.get(cartItem.getPhone().getPid());
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
			map.put(cartItem.getPhone().getPid(), _cartItem);
		}else {
			map.put(cartItem.getPhone().getPid(), cartItem);
		}
	}
	public void clear(){
		map.clear();
	}
	public void delete(String pid){
		map.remove(pid);
		
	}
	public Collection<CartItem> getCartItems(){
		return map.values();
	}

}
