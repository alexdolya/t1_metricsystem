package ru.dolya.metricsconsumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dolya.metricsconsumer.model.dto.MetricDataDto;
import ru.dolya.metricsconsumer.model.dto.MetricDataResponseDto;
import ru.dolya.metricsconsumer.model.entity.MetricData;

@Mapper
public interface MetricMapper {
    MetricMapper INSTANCE = Mappers.getMapper(MetricMapper.class);

    MetricData metricDataDtoToMetricData(MetricDataDto metricDataDto);
    MetricDataResponseDto metricDataToMetricDataResponseDto(MetricData metricData);
}
