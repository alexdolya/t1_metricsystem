package ru.dolya.metricsconsumer.service;

import org.springframework.transaction.annotation.Transactional;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;

public interface MetricService {
    @Transactional
    void save(MetricDataDto metricDataDto);
}
