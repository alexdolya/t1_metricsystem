package ru.dolya.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MetricService metricService;

    @KafkaListener(groupId = "t1-group", topics = "metrics-topic")
    public void consumeMetric(MetricDataDto metricDataDto) {
        metricService.save(metricDataDto);
        log.info("Сохранено в БД: {}", metricDataDto.toString());
    }

}
