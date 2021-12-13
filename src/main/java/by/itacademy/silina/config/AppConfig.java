package by.itacademy.silina.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"by.itacademy.silina"})
@EnableAspectJAutoProxy
public class AppConfig {
}
