package ru.dolya.metricsconsumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dolya.metricsconsumer.mapper.MetricMapper;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;
import ru.dolya.metricsconsumer.model.entity.MetricData;
import ru.dolya.metricsconsumer.repository.MetricRepository;
import ru.dolya.metricsconsumer.service.MetricService;

@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;

    @Override
    @Transactional
    public void save(MetricDataDto metricDataDto){
        MetricData metricData = MetricMapper.INSTANCE.metricDataDtoToMetricData(metricDataDto);
        metricRepository.save(metricData);
    }

}
