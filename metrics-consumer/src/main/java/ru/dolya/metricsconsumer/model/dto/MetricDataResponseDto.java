package ru.dolya.metricsconsumer.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class MetricDataResponseDto {

    private Long id;
    private String metric;
    private String metricValue;
    private LocalDateTime timestamp;
}
