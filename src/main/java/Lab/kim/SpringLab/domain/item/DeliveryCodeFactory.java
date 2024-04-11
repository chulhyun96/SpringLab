package Lab.kim.SpringLab.domain.item;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCodeFactory {
    private static final List<DeliveryCode> deliveryCode = new ArrayList<>();

    static {
        deliveryCode.add(new DeliveryCode("FAST","빠른배송"));
        deliveryCode.add(new DeliveryCode("NORMAL","보통배송"));
        deliveryCode.add(new DeliveryCode("SLOW","느린배송"));
    }
    public static List<DeliveryCode> getDeliveryCodes() {
        return deliveryCode;
    }
}
