package com.java.DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MySingleton {

	public static MySingleton singleInstance = null;

	public MySingleton getInstance() {
		
		if(singleInstance==null){
			singleInstance=new MySingleton();
		}
		
		return singleInstance;

	}

	

}
