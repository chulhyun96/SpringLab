package SpringLab.domain.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Item {
    //id, 상품명, 가격, 수량
    //수량이나 가격이 null(값이 없는채로 등록될 수도 있기 때문에 Integer 타입으로 선언)
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    public Item() {
    }
    //id값은 자동증가
    public Item(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
