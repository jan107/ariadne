package com.es.ariadne.configuration;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventTrackingConfiguration {

	@Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(Arrays.asList("dozer-mapping.xml"));
        return dozerBean;
    }
}
