package by.itacademy.silina.aspect;

import by.itacademy.silina.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WorkAspect {

    @Pointcut("execution(* by.itacademy.silina.service.MessageService.*(..))")
    private void logMethod() {
    }

    @Before("logMethod()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget()
                .getClass().getSimpleName();
        log.info("Method \"{}\" of \"{}\" has started execution", methodName, className);
    }

    @Around("execution(* by.itacademy.silina.service.MessageService.getModifiedMessage(..))")
    public Message logAround(ProceedingJoinPoint joinPoint) {
        log.info("Start modifying the message!");
        Message message = null;
        try {
            message = (Message) joinPoint.proceed();
            log.info("Finish modifying the message!");
        } catch (Throwable e) {
            String methodName = joinPoint.getSignature().getName();
            log.error("Exception during execution of method: {}", methodName, e);
        }
        return message;
    }

    @After("logMethod()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget()
                .getClass().getSimpleName();
        log.info("Method \"{}\" of \"{}\" has finished execution", methodName, className);
    }

    @AfterThrowing(pointcut = "logMethod()", throwing = "ex")
    public void logAfterThrow(Throwable ex) {
        log.error("Exception has been thrown!");
    }

    @AfterReturning(pointcut = "logMethod()", returning = "someValue")
    public void logReturningValue(Object someValue) {
        log.info("Value: {}", someValue.toString());
    }
}
