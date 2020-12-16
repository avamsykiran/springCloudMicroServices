package in.tp.lts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanTypesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanTypesMicroserviceApplication.class, args);
	}

}
