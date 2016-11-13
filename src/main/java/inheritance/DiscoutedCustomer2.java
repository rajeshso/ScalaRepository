package inheritance;

/**
 * Created by E797240 on 02/11/2016.
 */
class DiscoutedCustomer2 extends Customer2 {
    DiscoutedCustomer2(String name, String address) {
        super(name, address);
    }

    @Override
    Double total() {
        return super.total() * 0.90;
    }
}
