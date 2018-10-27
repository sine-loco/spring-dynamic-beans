package ru.snm.misc.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sine-loco
 */
@CreatePojo( prefix = "case-01" )
@ConfigurationProperties( prefix = "case-01" )
public class CaseOneParameters extends Parameters {
}
