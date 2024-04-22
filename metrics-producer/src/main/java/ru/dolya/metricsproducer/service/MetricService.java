package ru.dolya.metricsproducer.service;

import ru.dolya.metricsproducer.model.Metric;
import ru.dolya.metricsproducer.model.dto.MetricDataDto;

import java.util.List;

public interface MetricService {
    List<MetricDataDto> logMetrics(List<Metric> metrics);
}
