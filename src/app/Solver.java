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
			
			Node E = (Node)(L.get(0).clone());
			L.remove(0);
			Node F = prune(E);
			if(!(F.hasEmptyDomain())){
				if(F.isSolution()){
					showSolution(F);
				}
				else {
					int index = F.smallestDomainIndex();
					for(Integer v : F.getDomains().get(index).getValues() ){
						Node G = (Node)F.clone();
						G.getDomains().get(index).getValues().clear();
						G.getDomains().get(index).getValues().add(v);
						L.add(G);
					}
				}
			}
			
		}
	}

	private void showSolution(Node f) {
		System.out.println("Solution found :");
		for(int i=0; i<variables.size() ;++i){
			String line = "";
			for(int j=0 ; j< variables.size() ;++j){				
				if(j == f.getDomains().get(i).getValues().first()) line  = line + "O";
				else line = line + "-";
				
			}
			System.out.println(line);
		}
		System.out.println("======================");
	}

	private Node prune(Node e) {
		Node res = (Node)e.clone();
		for(Constraint c : constraints){
			c.apply(res.getDomains());
		}
		return res;
	}
	
	
}
