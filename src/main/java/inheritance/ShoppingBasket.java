package inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E797240 on 02/11/2016.
 */
class ShoppingBasket {
    private List<String> itemList = new ArrayList<String>();
    public void add(String item) {
        itemList.add(item);
    }
    public Double total() {
        return 100.00;
    }
}
