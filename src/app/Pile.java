package app;

import java.util.List;


public class Pile<T> {
	private final List<T> stk;
	
	public Pile(List<T> l) {
		stk = l;
	}
}
