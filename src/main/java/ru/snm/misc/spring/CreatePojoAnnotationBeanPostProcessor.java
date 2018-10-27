package ru.snm.misc.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CreatePojoAnnotationBeanPostProcessor implements
        BeanDefinitionRegistryPostProcessor
{
    final static String CLASS_NAME = "createPojoAnnotationBeanPostProcessor";

    @Override
    public void postProcessBeanDefinitionRegistry( BeanDefinitionRegistry registry) throws
            BeansException
    {
        //String prefix = "case-01";

        ArrayList<String> definitionNames = new ArrayList<>();
        for ( String name : registry.getBeanDefinitionNames() ) {
            BeanDefinition def = registry.getBeanDefinition( name );
            if ( def instanceof GenericBeanDefinition ) {
                GenericBeanDefinition gdef = ( GenericBeanDefinition ) def;
                if( !gdef.hasBeanClass() ) { continue; }
                if ( Parameters.class == gdef.getBeanClass().getSuperclass() ) {
                    definitionNames.add( name );
                }
            }
        }


        for ( String name: definitionNames ) {
            String prefix = name.substring( 0, name.lastIndexOf( "-" ) );
            BeanDefinitionBuilder amqCf =
                    BeanDefinitionBuilder
                            .genericBeanDefinition( PojoWithParameters.class )
                            .setLazyInit( true )
                            .setFactoryMethodOnBean( "createPojo", CLASS_NAME )
                            .addConstructorArgReference( name );
            registry.registerBeanDefinition( prefix + "-Pojo", amqCf.getBeanDefinition() );
        }

    }

    @Override
    public void postProcessBeanFactory( ConfigurableListableBeanFactory beanFactory) throws BeansException {}


    <T extends Parameters> PojoWithParameters createPojo( T bps ) {
        PojoWithParameters cf = new PojoWithParameters();
        cf.setBrokerUrl( bps.getBrokerUrl() );
        cf.setUsername( bps.getUsername() );
        cf.setPassword( bps.getPassword() );
        return cf;
    }

}