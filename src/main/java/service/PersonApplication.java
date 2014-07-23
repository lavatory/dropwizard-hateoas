package service;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.server.linking.LinkFilter;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.PersonResource;

public class PersonApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new PersonApplication().run(new String[]{"server"});
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new PersonResource());
        environment.jersey().property(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LinkFilter.class);
    }
}