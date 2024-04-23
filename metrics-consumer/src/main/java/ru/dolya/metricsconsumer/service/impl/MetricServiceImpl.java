package ru.dolya.metricsconsumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dolya.metricsconsumer.exception.MetricNotFoundException;
import ru.dolya.metricsconsumer.mapper.MetricMapper;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;
import ru.dolya.metricsconsumer.model.dto.MetricDataResponseDto;
import ru.dolya.metricsconsumer.model.entity.MetricData;
import ru.dolya.metricsconsumer.repository.MetricRepository;
import ru.dolya.metricsconsumer.service.MetricService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;

    @Override
    @Transactional
    public void save(MetricDataDto metricDataDto) {
        MetricData metricData = MetricMapper.INSTANCE.metricDataDtoToMetricData(metricDataDto);
        metricRepository.save(metricData);
    }

    @Override
    @Transactional
    public List<MetricDataResponseDto> findAll() {
        List<MetricData> allMetrics = metricRepository.findAll();
        return allMetrics.stream()
                .map(MetricMapper.INSTANCE::metricDataToMetricDataResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MetricDataResponseDto findById(Long id) {
        Optional<MetricData> metricData = metricRepository.findById(id);
        if (metricData.isPresent()){
            return MetricMapper.INSTANCE.metricDataToMetricDataResponseDto(metricData.get());
        } else {
            throw new MetricNotFoundException("Мерика с id " + id + " не найдена");
        }
    }

}
