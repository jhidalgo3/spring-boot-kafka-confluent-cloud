package me.jhidalgo3.kafka.stock.ticker.producer.avro;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import me.jhidalgo3.stock.tick.avro.StockTick;

@Component
public class RandomStockTickProducer {

  private final StockTickProducer stockTickProducer;
  private final RandomStockTickGenerator randomStockTickGenerator;

  public RandomStockTickProducer(StockTickProducer stockTickProducer, RandomStockTickGenerator randomStockTickGenerator) {
    this.stockTickProducer = stockTickProducer;
    this.randomStockTickGenerator = randomStockTickGenerator;
  }

  @Scheduled(fixedRateString = "${stockTick.producer.rateInMs}")
  public void produceRandomStockTick() {
    StockTick stockTick = randomStockTickGenerator.generateRandomStockTick();
    stockTickProducer.produce(stockTick);
  }
}
