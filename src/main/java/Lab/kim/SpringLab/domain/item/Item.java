package Lab.kim.SpringLab.domain.item;


import Lab.kim.SpringLab.type.ItemType;
import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private Boolean open;// 판매여부
    private List<String> regions; //등록지역
    private String deliveryCode;// 배송방식
    private ItemType itemType;//상품 종류
    public Item() {
    }
    //id값은 자동증가
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
