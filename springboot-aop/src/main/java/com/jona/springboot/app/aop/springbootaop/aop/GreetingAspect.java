package com.jona.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    //Instancia de Logger para la clase actual
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);
    
    @Before("execution(String com.jona.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    // JoinPoint, que proporciona información sobre el o los métodos objetivo que se está interceptando.
    // JoinPoint se utiliza principalmente en los aspectos que "necesitan información detallada sobre la invocación del método".
    // Si no requieres información específica del método, no es necesario pasar JoinPoint
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }
}
