package ru.snm.misc.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sine-loco
 */
@CreatePojo( prefix = "case-02" )
@ConfigurationProperties( prefix = "case-02" )
public class CaseTwoParameters extends Parameters {
}
