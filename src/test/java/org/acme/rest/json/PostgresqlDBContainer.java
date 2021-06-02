package org.acme.rest.json;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

@QuarkusTestResource(PostgresqlDBContainer.Initializer.class)
public class PostgresqlDBContainer {

    public static class Initializer implements QuarkusTestResourceLifecycleManager {
        // Defines the test resource interface

        // Sets PostGreSQLDB container object
        private PostgreSQLContainer postgresDBContainer;

        @Override
        public Map<String, String> start() {
            // Instantiate MariaDB container with required Docker image
            this.postgresDBContainer= new PostgreSQLContainer<>("postgres:latest");
            // Starts the container and waits until the container is accepting connections
            this.postgresDBContainer.start();
            return getConfigurationParameters();
        }

        private Map<String, String> getConfigurationParameters() {
            // Overrides Global Quarkus’s configuration Properties of connection to a Database to point and set database connection variables to connect the app with the container test.
            // to the container one

            final Map<String, String> conf = new HashMap<>();
            conf.put("quarkus.datasource.jdbc.url", this.postgresDBContainer.getJdbcUrl());
            conf.put("quarkus.datasource.username", this.postgresDBContainer.getUsername());
            conf.put("quarkus.datasource.password", this.postgresDBContainer.getPassword());
            // conf.put("quarkus.datasource.driver", this.mariaDBContainer.getDriverClassName());
            return conf;
        }

        @Override
        public void stop() {
            // Stops the container
            if (this.postgresDBContainer != null) {
                this.postgresDBContainer.close();
            }
        }
    }
}
