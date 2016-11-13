package javapackage;

public class CustomersUsageExample {

	public static void main(String... args) {
		Customers customers = new Customers();
		customers.add(new Customer1("Velma Dinkley", "316 Circle Drive"));
		customers.add(new Customer1("Daphne Blake", "101 Easy St"));
		customers.add(new Customer1("Fred Jones", "8 Tuna Lane,"));
		customers.add(new DiscountedCustomer("Norville Rogers", "1 Lane"));
		System.out.println(customers.sort());
		}
}
