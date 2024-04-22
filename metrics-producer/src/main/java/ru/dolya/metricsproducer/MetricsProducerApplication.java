package ru.dolya.metricsproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import ru.dolya.metricsproducer.model.dto.MetricDataDto;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class MetricsProducerApplication {


    public static void main(String[] args) {
        SpringApplication.run(MetricsProducerApplication.class, args);
    }


}
