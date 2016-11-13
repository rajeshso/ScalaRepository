package annonymousclasses;

/**
 * Created by E797240 on 02/11/2016.
 */
class Customer4 {
    Customer4(String name, String address) {
    }

    void addPoints(Point4 point) {
        System.out.println(point.getId());
    }
}
class Point4 {
    String id;
    Point4(String id) {
        this.id = id;
    }
    String getId() {
        return id;
    }
}

class Customer4Runner {
    public static void main(String... args) {
        Customer4 customer4 = new Customer4("Rajesh", "London");
        customer4.addPoints(new Point4("A"));
        customer4.addPoints(new Point4("B") {
            String getId() {
                return "AB";
            }
        });
    }
}
