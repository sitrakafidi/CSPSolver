package app;

import java.util.ArrayList;
import java.util.List;

public class Diagonal implements Constraint {

	private ArrayList<Integer> domainIndex;
	
	public Diagonal(ArrayList<Integer> domainIndex) {
		this.domainIndex = domainIndex;
	}

	@Override
	public void apply(List<Domain> domains) {
		for(int i : domainIndex){
			if(domains.get(i).getValues().size() == 1 ){
				suppValue(i, domains);
			}
		}

	}

	private void suppValue(int i, List<Domain> domains) {
		int xi = domains.get(i).getValues().first();
		for(int j : domainIndex){
			if(j>i){
				int xj1 = xi - j + i;
				int xj2 = xi + j - i;
				domains.get(j).getValues().remove(xj1);
				domains.get(j).getValues().remove(xj2);
			}
		}
		
	}

}
