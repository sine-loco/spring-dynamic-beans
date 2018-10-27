package ru.snm.misc.spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author sine-loco
 */
@Documented
@Target({ ElementType.TYPE })
@Retention( RetentionPolicy.RUNTIME )
public @interface CreatePojo {
    String prefix();
}
