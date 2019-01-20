package com.java.DataStructures;

import java.util.ArrayList;
import java.util.List;

class Credentials {

	public String password;

	public Credentials(String val) {
		this.password = val;

	}

	public void setPassword(String val) {
		this.password = val;
	}

	public String getPassword() {
		return this.password;
	}

}

// Implementing a generic class
public class Container<T> {

	T value;

	public void set(T input) {
		this.value = input;

	}

	public T get() {
		return value;
	}

	Container(T val) {
		this.value = val;
	}

	public static void main(String[] args) {

		 //Instantiating generic class with Wrqpper class
		 Container<Integer> Cinstance=new Container<Integer>(10);
		 Cinstance.set(20);
		 System.out.println(Cinstance.get());
		
		 //Instantiating generic class with type Credentials
		 Container<Credentials> Cinsantance2=new Container<Credentials>(new
		 Credentials("opensesame"));
		 System.out.println(Cinsantance2.get().password);



	}

}
