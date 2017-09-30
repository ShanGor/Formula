package tech.comfortheart.formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CalculateRequest {
    private String source;
    private Map<String, String> requestValues;

    public CalculateRequest() {
        requestValues = new ConcurrentHashMap<>();
    }

    public CalculateRequest(final String source) {
        this();
        setSource(source);
    }

    public final String getSource() {
        return source;
    }

    public CalculateRequest(final String source, final Map<String, String> requestValues) {
        this.source = source;
        this.requestValues = new ConcurrentHashMap<>(requestValues);
    }

    public final CalculateRequest setSource(final String source) {
        this.source = source;
        return this;
    }

    public final CalculateRequest setRequestValues(final Map<String, BigDecimal> requestValues) {
        requestValues.forEach((key, value) -> {
            this.requestValues.put(key, String.valueOf(value));
        });

        return this;
    }

    public final CalculateRequest addRequestValue(final String key, final String value) {
        this.requestValues.put(key, value);
        return this;
    }

    public final CalculateRequest addRequestValue(final String key, final BigDecimal value) {
        return this.addRequestValue(key, String.valueOf(value));
    }

    public final CalculateRequest addRequestValue(final String key, int value) {
        return this.addRequestValue(key, String.valueOf(value));
    }

    public final CalculateRequest addRequestValue(final String key, double value) {
        return this.addRequestValue(key, String.valueOf(value));
    }

    public final CalculateRequest addRequestValue(final String key, float value) {
        return this.addRequestValue(key, String.valueOf(value));
    }

    @JsonIgnore
    public final Map<String, BigDecimal> getNumericRequestValues() {
        ConcurrentHashMap<String, BigDecimal> map = new ConcurrentHashMap<>();
        this.requestValues.forEach((key, value) -> {
            map.put(key, new BigDecimal(value));
        });
        return map;
    }


    public final String getRequestValue(final String key) {
        return this.requestValues.get(key);
    }


    public final BigDecimal getRequestValueAsNumber(final String key) {
        return new BigDecimal(this.requestValues.get(key));
    }


    public final Map<String, String> getRequestValues() {
        return this.requestValues;
    }
}
