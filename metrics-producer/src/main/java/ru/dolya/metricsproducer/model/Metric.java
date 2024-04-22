package ru.dolya.metricsproducer.model;

public enum Metric {

    UPTIME("process.uptime"),
    JVM_MEMORY_MAX("jvm.memory.max"),
    JVM_MEMORY_USAGE("jvm.memory.used");

    private final String textValue;

    Metric(String textValue) {
        this.textValue = textValue;
    }

    public String value() {
        return textValue;
    }

    public static Metric fromValue(String value) {
        for (Metric metric : Metric.values()) {
            if (metric.textValue.equals(value)) {
                return metric;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
