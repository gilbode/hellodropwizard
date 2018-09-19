package com.wercker.example.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.server.SimpleServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.jetty.HttpConnectorFactory;
import io.dropwizard.setup.Environment;
import com.wercker.example.hellodropwizard.health.HelloHealthCheck;
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
      SimpleServerFactory serverFactory = new SimpleServerFactory();
      configuration.setServerFactory(serverFactory);

      int port = 8080;
      String portEnv = System.getenv("PORT");
      if (portEnv != null) {
        port = Integer.parseInt(portEnv);
      }
      HttpConnectorFactory connector = new HttpConnectorFactory();
      connector.setPort(port);
      serverFactory.setConnector(connector);

      environment.jersey().register(new AppVersionResource());
      environment.healthChecks().register("hello", new HelloHealthCheck());
    }

}
