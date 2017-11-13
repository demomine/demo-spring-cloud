package com.lance.demo.springcloud.server.sleuth.config;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanTextMap;
import org.springframework.cloud.sleuth.instrument.messaging.MessagingSpanTextMapExtractor;
import org.springframework.cloud.sleuth.util.TextMapUtil;

import java.util.Map;

public class ZipkinExtractor implements MessagingSpanTextMapExtractor {
    @Override
    public Span joinTrace(SpanTextMap carrier) {
            Map<String, String> map = TextMapUtil.asMap(carrier);
            long traceId = Span.hexToId(map.get("correlationid"));
            long spanId = Span.hexToId(map.get("myspanid"));
            // extract all necessary headers
            Span.SpanBuilder builder = Span.builder().traceId(traceId).spanId(spanId);
            // build rest of the Span
            return builder.build();
    }
}
