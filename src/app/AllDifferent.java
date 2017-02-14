package app;

import java.util.ArrayList;

public class AllDifferent implements Constraint {

	@Override
	public void apply(ArrayList<Domain> domains) {
		for(Domain d : domains){
			if(d.getValues().size() == 1 ){
				
			}
		}

	}

}
