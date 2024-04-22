package ru.dolya.metricsproducer.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class MetricDataDto {

    private String metric;
    private String metricValue;
    private LocalDateTime timestamp;

}
