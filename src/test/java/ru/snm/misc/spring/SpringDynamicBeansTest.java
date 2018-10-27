package ru.snm.misc.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplicationExtensionsKt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sine-loco
 */
@SpringBootTest
@ExtendWith( SpringExtension.class )
class SpringDynamicBeansTest {
    private final static Logger logger = LogManager.getLogger();

    @Autowired ApplicationContext context;

    @Autowired @Qualifier( "case-01-Pojo")
    PojoWithParameters c1;

    @Autowired @Qualifier( "case-02-Pojo")
    PojoWithParameters c2;


    @Test
    void t() {
        c1.getUsername();
    }

}