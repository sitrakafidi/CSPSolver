package app;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Domain> domains;

	public Node(){
		domains = new ArrayList<Domain>();
	}
	
	public Node(List<Domain> domains) {
		super();
		this.domains = domains;
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
			else ++i;
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
	
	//PRE : this.node is not a solution
	public int smallestDomainIndex() {
		int min = 0;
		while(domains.get(min).getValues().size()<=1) ++min;
		for(int i=0; i<domains.size(); ++i){
			if(( domains.get(i).getValues().size()<domains.get(min).getValues().size()) && (domains.get(i).getValues().size() > 1) ){
				min = i;
			}
		}
		return min;
	}
	
	public boolean hasEmptyDomain() {
		boolean empty = false;
		int i = 0;
		while((!empty)&&(i<domains.size())){
			if(domains.get(i).getValues().isEmpty()) empty = true;
			else ++i;
		}
		return empty;
	}
	
	public Object clone(){
		List<Domain> doms = new ArrayList<Domain>();
		for(Domain d : this.domains){
			doms.add((Domain)d.clone());
		}
		Object res = new Node(doms);
		return res;
	}
}
