package app;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//problème des N reines
		int N = 10;
		
		
		
		//Variables
		ArrayList<String> var = new ArrayList<String>(); 
		for(int i=0; i<N ; ++i){
			var.add("x"+i);
		}
		
		//Contraintes
		ArrayList<Constraint> constr = new ArrayList<Constraint>();
		
		ArrayList<Integer> indexCol = new ArrayList<Integer>();
		for(int i=0; i<N ; ++i){
			indexCol.add(i);
		}
		Constraint columns = new AllDifferent(indexCol);
		constr.add(columns);
		
		Constraint diagonal = new Diagonal(indexCol);
		constr.add(diagonal);
		
		//Initial Node
		ArrayList<Domain> doms = new ArrayList<Domain>();
		for(int i=0; i<N ;++i){
			TreeSet<Integer> initSet = new TreeSet<Integer>();
			for(int j=0 ; j<N ; ++j ) initSet.add(j);
			doms.add(new Domain((TreeSet<Integer>)initSet.clone()));
		}
		Node init = new Node(doms);
		
		//Chrono
		//Chrono chrono = new Chrono();
		
		
		Solver queenSolv = new Solver(var,constr,init);
		queenSolv.branchAndPrune();
		/*
		ArrayList<String> var = new ArrayList<String>(); 
		for(int i=0; i<4 ; ++i){
			var.add("x"+i);
		}
		
		ArrayList<String> bis = new ArrayList<String>();
		bis = (ArrayList<String>)var.clone();
		bis.add("kaiza");
		System.out.println(var.toString());
		System.out.println(bis.toString());
		*/
	}

}
