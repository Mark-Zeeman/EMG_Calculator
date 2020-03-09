package com.emguidance.assessment.markzeeman.emgcalculator.config;


import com.emguidance.assessment.markzeeman.emgcalculator.service.CalculationsService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(CalculationsService.class);
    }
}