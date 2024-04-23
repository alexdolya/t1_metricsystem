package ru.dolya.metricsconsumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.dolya.metricsconsumer.model.dto.MetricDataResponseDto;
import ru.dolya.metricsconsumer.service.MetricService;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
public class MetricController {

    private final MetricService metricService;

    @Operation(summary = "Получить данные записанных метриках")
    @GetMapping("/metrics")
    public List<MetricDataResponseDto> getMetrics() {
        return metricService.findAll();
    }

    @Operation(summary = "Получить данные о конкретной метрике")
    @GetMapping("/metrics/{id}")
    public MetricDataResponseDto getMetric(@PathVariable Long id) {
        return metricService.findById(id);
    }

}
