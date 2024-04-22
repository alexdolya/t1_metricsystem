package ru.dolya.metricsproducer.model.dto;

import lombok.Data;
import ru.dolya.metricsproducer.model.Metric;

import java.util.List;

@Data
public class MetricRequestDto {

    private List<Metric> requestedMetrics;
}
