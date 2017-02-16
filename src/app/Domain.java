package app;

import java.util.SortedSet;
import java.util.TreeSet;

public class Domain {
	private TreeSet<Integer> values;

	public Domain() {
		this.values = new TreeSet<Integer>();
	}
	
	public Domain(TreeSet<Integer> values) {
		this.values = values;
	}

	public SortedSet<Integer> getValues() {
		return values;
	}

	public void setValues(TreeSet<Integer> values) {
		this.values = values;
	}
	
	public void supprValue(int value){
		values.remove(value);
	}
	
	@SuppressWarnings("unchecked")
	public Object clone(){
		Object res = new Domain((TreeSet<Integer>)this.values.clone());
		return res;
	}
	
}
