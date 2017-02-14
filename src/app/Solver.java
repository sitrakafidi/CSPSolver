package app;

import java.util.ArrayList;

public class Solver {

	private ArrayList<String> variables;
	private ArrayList<Constraint> constraints;
	private Node initialNode;
	
	public Solver(ArrayList<String> variables,ArrayList<Constraint> constraints, Node initialNode) {
		this.variables = variables;
		this.constraints = constraints;
		this.initialNode = initialNode;
	}
	
	public void branchAndPrune(){
		ArrayList<Node> L = new ArrayList<Node>();
		L.add(initialNode);
		while(!L.isEmpty()){
			Node E = L.remove(0);
			Node F = prune(E);
			if(!(F.getDomains().isEmpty())){
				if(F.isSolution()){
					System.out.println("Solution :"+F.toString());
				}
				else {
					int index = F.smallestDomainIndex();
					for(int v : F.getDomains().get(index).getValues() ){
						Node G = F;
						G.getDomains().get(index).getValues().clear();
						G.getDomains().get(index).getValues().add(v);
						L.add(G);
					}
				}
			}
			
			
		}
	}

	private Node prune(Node e) {
		
		return null;
	}
	
	
}
