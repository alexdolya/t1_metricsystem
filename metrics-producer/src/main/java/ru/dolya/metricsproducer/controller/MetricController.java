package ru.dolya.metricsproducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dolya.metricsproducer.model.Metric;
import ru.dolya.metricsproducer.model.dto.MetricDataDto;
import ru.dolya.metricsproducer.service.MetricService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MetricController {

    private final MetricService metricService;

    @Operation(summary = "Получить данные о метриках")
    @PostMapping("/metrics")
    public List<MetricDataDto> requestMetrics(@RequestBody List<Metric> requestedMetrics) {
        log.info("Запрос метрик: {}", requestedMetrics);
        return metricService.logMetrics(requestedMetrics);
    }

}
