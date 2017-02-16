package app;


import java.util.List;

public interface Constraint {

	public void apply(List<Domain> domains);
}
