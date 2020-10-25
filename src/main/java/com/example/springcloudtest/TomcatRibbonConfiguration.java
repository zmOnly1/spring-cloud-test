package com.example.springcloudtest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zm on 2018/8/24.
 */
@Configuration
@RibbonClient(name = "tomcat", configuration = TomcatConfiguration.class)
public class TomcatRibbonConfiguration {

}
