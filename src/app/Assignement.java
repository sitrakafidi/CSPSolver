package app;

import java.util.ArrayList;

public class Assignement {

	private ArrayList<Integer> values;

	public Assignement(){
		values = new ArrayList<Integer>();
	}
	
	public Assignement(ArrayList<Integer> values) {
		this.values = values;
	}
	
	public ArrayList<Integer> getValues() {
		return values;
	}

	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}

	
	
}
