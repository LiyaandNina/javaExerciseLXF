package org.example.metrics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MetricAspect {

    @Around("@annotation(mt)")
    public Object metrics(ProceedingJoinPoint pjp, MetricTime mt) throws Throwable {
        String name = mt.value();
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            long t = System.currentTimeMillis() - start;
            // 写入日志或发送至JMX:
            System.err.println("[Metrics] " + name + ": " + t + "ms");
        }
    }
}
