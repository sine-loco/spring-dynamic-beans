package ru.snm.misc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author sine-loco
 */
@SpringBootApplication
@EnableConfigurationProperties( { CaseOneParameters.class, CaseTwoParameters.class })
public class SpringDynamicBeans {
    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication( SpringDynamicBeans.class );
        //app.addListeners( new CreatePojoAnnotationBeanPostProcessor() );
        app.run( args );
    }
}
