package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryPicked'"
    )
    public void wheneverDeliveryPicked_UpdateOrderStatus(
        @Payload DeliveryPicked deliveryPicked
    ) {
        DeliveryPicked event = deliveryPicked;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + deliveryPicked + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_UpdateOrderStatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_UpdateOrderStatus(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryFinished'"
    )
    public void wheneverDeliveryFinished_UpdateOrderStatus(
        @Payload DeliveryFinished deliveryFinished
    ) {
        DeliveryFinished event = deliveryFinished;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " +
            deliveryFinished +
            "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }
}
