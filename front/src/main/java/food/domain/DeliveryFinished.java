package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeId;
    private String customerId;
    private String address;
    private Long qty;
    private String foodId;
    private String status;
}
