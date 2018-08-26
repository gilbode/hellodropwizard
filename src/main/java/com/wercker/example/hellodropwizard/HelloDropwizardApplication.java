package com.wercker.example.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.wercker.example.hellodropwizard.resources.AppVersionResource;

public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "hellodropwizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloDropwizardConfiguration> bootstrap) {
    }

    @Override
    public void run(final HelloDropwizardConfiguration configuration,
                    final Environment environment) {
      environment.jersey().register(new AppVersionResource());
    }

}
