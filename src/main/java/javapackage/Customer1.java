package javapackage;

public class Customer1 implements Comparable<Customer1> {
	private final String name;
	private final String address;

	Customer1(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public int compareTo(Customer1 other) {
		return name.compareTo(other.name);
	}
	
	public String toString() {
		return name + " " + address;
	}
}
