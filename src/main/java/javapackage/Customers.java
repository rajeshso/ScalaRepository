package javapackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Customers implements Sortable<Customer1> {
	private final Set<Customer1> customers = new HashSet<>();

	public void add(Customer1 e) {
		customers.add(e);
	}

	@Override
	public Iterator<Customer1> iterator() {
		return customers.iterator();
	}

}
