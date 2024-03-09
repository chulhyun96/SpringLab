package Lab.Singtone;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // -> 해당 코드조각이 문제가 된다. 내부에서 들어온 정보가 자신한테 할당 될 때 (stateful)
    }

    public int getPrice() {
        return price;
    }
}
