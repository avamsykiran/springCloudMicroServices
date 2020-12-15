package in.tp.lmds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoanManagementDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementDiscoveryServiceApplication.class, args);
	}

}
