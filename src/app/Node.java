package app;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Domain> domains;

	public Node(){
		domains = new ArrayList<Domain>();
	}
	public List<Domain> getDomains() {
		return domains;
	}

	public void setDomains(ArrayList<Domain> domains) {
		this.domains = domains;
	}
	
	public boolean isSolution() {
		boolean res = true;
		int i = 0 ;
		while(res && i<domains.size()){
			if(domains.get(i).getValues().size() != 1) res = false;
		}
		return res;
	}
	
	public String toString(){
		String res = "";
		for(int i=0; i < domains.size(); ++i ){
			res = res + "   " + domains.get(i).getValues().toString();
		}
		return res;
	}
	public int smallestDomainIndex() {
		int min = 0;
		for(int i=0; i<domains.size(); ++i){
			if(domains.get(i).getValues().size()<domains.get(min).getValues().size()){
				min = i;
			}
		}
		return min;
	}
	
}
