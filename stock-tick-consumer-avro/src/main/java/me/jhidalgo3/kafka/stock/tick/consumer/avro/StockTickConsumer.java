package me.jhidalgo3.kafka.stock.tick.consumer.avro;

import static me.jhidalgo3.kafka.stock.tick.consumer.avro.StockTickConsumerAvroApplication.TOPIC_NAME;
import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.jhidalgo3.stock.tick.avro.StockTick;

@Component
@Slf4j
public class StockTickConsumer {

  @KafkaListener(topics = TOPIC_NAME)
  public void listen(StockTick stockTick, @Header(RECEIVED_PARTITION_ID) Integer partitionId) {
    log.info("Consumed: {}, {} {} from partition: {}", stockTick.getSymbol(), stockTick.getCurrency(),
      stockTick.getTradeValue(), partitionId);
  }

}
