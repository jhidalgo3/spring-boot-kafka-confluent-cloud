package me.jhidalgo3.kafka.stock.ticker.producer.avro;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.jhidalgo3.stock.tick.avro.StockTick;

@Slf4j
@Component
public class StockTickProducer {

  private final KafkaTemplate<String, StockTick> kafkaTemplate;

  public StockTickProducer(KafkaTemplate<String, StockTick> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produce(StockTick stockTick) {
    log.info("Produce stock tick: {}, {} {}", stockTick.getSymbol(), stockTick.getCurrency(), stockTick.getTradeValue());
    kafkaTemplate.send(StockTickProducerAvroApplication.TOPIC_NAME, stockTick.getSymbol(), stockTick);
  }
}