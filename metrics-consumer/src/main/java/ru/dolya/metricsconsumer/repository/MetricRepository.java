package ru.dolya.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dolya.metricsconsumer.model.entity.MetricData;

public interface MetricRepository extends JpaRepository<MetricData, Long> {
}
