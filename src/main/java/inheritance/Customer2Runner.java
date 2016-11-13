package inheritance;

/**
 * Created by E797240 on 02/11/2016.
 */
public class Customer2Runner {
    public static void main(String... args) {
        Customer2 customer2 = new Customer2("Rajesh", "London");
        customer2.add("Book: Scala in depth");
        System.out.println(customer2.total());

        DiscoutedCustomer2 discoutedCustomer2 = new DiscoutedCustomer2("Raj","London");
        discoutedCustomer2.add("Book: Scala Puzzlers");
        System.out.println(discoutedCustomer2.total());
    }
}
