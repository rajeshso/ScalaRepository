package inheritance;

/**
 * Created by E797240 on 02/11/2016.
 */
class Customer2 {
    private String name;
    private String address;
    private final ShoppingBasket basket = new ShoppingBasket();

    Customer2(String name, String address) {
        this.name = name;
        this.address = address;
    }

    void add(String item) {
        basket.add(item);
    }

    Double total() {
        return basket.total();
    }
}
