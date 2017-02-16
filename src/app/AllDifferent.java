package app;

import java.util.ArrayList;
import java.util.List;

public class AllDifferent implements Constraint {
	
	private ArrayList<Integer> domainIndex;
	
	public AllDifferent(ArrayList<Integer> domainIndex) {
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

	private void suppValue(Integer index, List<Domain> domains) {
		int val = domains.get(index).getValues().first();
		for(int i : domainIndex){	
			if((i!=index) && (domains.get(i).getValues().contains(val))){
				domains.get(i).getValues().remove(val);
			}
		}
	}

}
