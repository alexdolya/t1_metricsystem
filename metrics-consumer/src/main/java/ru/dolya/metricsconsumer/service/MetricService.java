package ru.dolya.metricsconsumer.service;

import org.springframework.transaction.annotation.Transactional;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;
import ru.dolya.metricsconsumer.model.dto.MetricDataResponseDto;

import java.util.List;

public interface MetricService {
    @Transactional
    void save(MetricDataDto metricDataDto);

    @Transactional
    List<MetricDataResponseDto> findAll();

    @Transactional
    MetricDataResponseDto findById(Long id);
}
