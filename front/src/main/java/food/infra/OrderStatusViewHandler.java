package food.infra;

import food.config.kafka.KafkaProcessor;
import food.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusViewHandler {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setStatus(orderPlaced.getStatus());
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_1(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                Long.valueOf(cookStarted.getOrderId())
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus(cookStarted.getStatus());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_2(
        @Payload CookFinished cookFinished
    ) {
        try {
            if (!cookFinished.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                Long.valueOf(cookFinished.getOrderId())
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus(cookFinished.getStatus());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryPicked_then_UPDATE_3(
        @Payload DeliveryPicked deliveryPicked
    ) {
        try {
            if (!deliveryPicked.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                Long.valueOf(deliveryPicked.getOrderId())
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus(deliveryPicked.getStatus());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryFinished_then_UPDATE_4(
        @Payload DeliveryFinished deliveryFinished
    ) {
        try {
            if (!deliveryFinished.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                Long.valueOf(deliveryFinished.getOrderId())
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus(deliveryFinished.getStatus());
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
