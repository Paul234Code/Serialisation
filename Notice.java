package com.serialisation.object;

import java.io.Serializable;

public class Notice implements Serializable{
	private String langue;
	
	
	public Notice() {
		this.langue= "Francais";
	}
	public Notice (String lang) {
		this.langue=lang;
	}
	public String toString() {
		return "Notice :" +this.langue;
	}

}
