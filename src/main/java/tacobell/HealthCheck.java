package tacobell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
           // return Health.down()
             //       .withDetail("Error Code", errorCode).build();
            return Health.down().withDetail("error", "DB Not Available").build();
        }
        return Health.up().build();
    }

    public int check() {
        // Our logic to check health
        // check db available
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "")) {
        } catch (SQLException e) {
            log.warn("DB not available");
            return -1;
        }
        return 0;
    }


}
