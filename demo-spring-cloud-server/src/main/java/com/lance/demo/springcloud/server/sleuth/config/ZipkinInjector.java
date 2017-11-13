package com.lance.demo.springcloud.server.sleuth.config;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanTextMap;
import org.springframework.cloud.sleuth.instrument.web.HttpSpanInjector;
import org.springframework.cloud.sleuth.util.TextMapUtil;
import org.springframework.util.StringUtils;

import java.util.Map;

public class ZipkinInjector implements HttpSpanInjector{

    public ZipkinInjector() {
    }

    public void inject(Span span, SpanTextMap map) {
        Map<String, String> carrier = TextMapUtil.asMap(map);
        this.setHeader(map, carrier, "X-B3-TraceId", span.traceIdString());
        this.setIdHeader(map, carrier, "X-B3-SpanId", span.getSpanId());
        this.setHeader(map, carrier, "X-B3-Sampled", span.isExportable() ? "1" : "0");
        this.setHeader(map, carrier, "X-Span-Name", span.getName());
        this.setIdHeader(map, carrier, "X-B3-ParentSpanId", this.getParentId(span));
        this.setHeader(map, carrier, "X-Process-Id", span.getProcessId());
        this.setHeader(map, carrier, "serviceName", "demo-spring-cloud");

        for (Map.Entry<String, String> entry : span.baggageItems()) {
            map.put(this.prefixedKey(entry.getKey()), entry.getValue());
        }

    }

    private String prefixedKey(String key) {
        return key.startsWith("baggage-") ? key : "baggage-" + key;
    }

    private Long getParentId(Span span) {
        return !span.getParents().isEmpty() ? span.getParents().get(0) : null;
    }

    private void setIdHeader(SpanTextMap map, Map<String, String> carrier, String name, Long value) {
        if (value != null) {
            this.setHeader(map, carrier, name, Span.idToHex(value));
        }

    }

    private void setHeader(SpanTextMap map, Map<String, String> carrier, String name, String value) {
        if (StringUtils.hasText(value) && !carrier.containsKey(name)) {
            map.put(name, value);
        }

    }
}
