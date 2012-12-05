package com.park;

import java.util.UUID;

public class Ticket {

//	String ticket_id = null;
//
//	public Ticket(String ticket_id) {
//		this.ticket_id = ticket_id;
//	}
//	String ps_name = null;
//
//	public String getPs() {
//		return ps_name;
//	}
//
//	public void setPs(String ps_name) {
//		this.ps_name = ps_name;
//	}
//	
//	
    public String getTicket(){
    	
    	UUID uuid = UUID.randomUUID();
    	
    	return uuid.toString();
    }
	
}
