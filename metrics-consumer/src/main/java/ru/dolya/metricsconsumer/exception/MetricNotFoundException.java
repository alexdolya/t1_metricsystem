package ru.dolya.metricsconsumer.exception;

public class MetricNotFoundException extends RuntimeException {
    public MetricNotFoundException(String message) {
        super(message);
    }

}
