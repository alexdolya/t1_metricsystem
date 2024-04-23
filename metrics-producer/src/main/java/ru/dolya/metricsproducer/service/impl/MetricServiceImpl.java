package ru.dolya.metricsproducer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.dolya.metricsproducer.model.Metric;
import ru.dolya.metricsproducer.model.dto.MetricDataDto;
import ru.dolya.metricsproducer.service.MetricService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class MetricServiceImpl implements MetricService {

    private final MetricsEndpoint metricsEndpoint;

    private final KafkaTemplate<String, MetricDataDto> template;

    @Value(value = "${kafka.topic.metrics-topic:metrics-topic}")
    private String metricsTopic;

    @Scheduled(fixedRate = 180000)
    public void logMetrics(){
        for (Metric metric : Metric.values()) {
            log.info("Отправка метрики {} по расписанию", metric);
            getMetricAndSendToBroker(metric);
        }
    }

    @Override
    public List<MetricDataDto> logMetrics(List<Metric> metrics) {
        List<MetricDataDto> result = new ArrayList<>();
        for (Metric metric : metrics) {
            log.info("Отправка метрики {} по запросу пользователя", metric);
            MetricDataDto metricDataDto = getMetricAndSendToBroker(metric);
            result.add(metricDataDto);
        }
        return result;
    }

    private MetricDataDto getMetricAndSendToBroker(Metric metric){
        List<MetricsEndpoint.Sample> measurements = metricsEndpoint.metric(metric.value(), null).getMeasurements();
        Double value = measurements.get(0).getValue();
        MetricDataDto metricDataDto = new MetricDataDto()
                .setMetric(metric.name())
                .setMetricValue(String.valueOf(value))
                .setTimestamp(LocalDateTime.now());
        template.send(metricsTopic, metricDataDto);
        return metricDataDto;
    }

}
