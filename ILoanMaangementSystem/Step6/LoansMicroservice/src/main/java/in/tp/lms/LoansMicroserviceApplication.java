package in.tp.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("in.tp.lms.service")
@EnableDiscoveryClient
public class LoansMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansMicroserviceApplication.class, args);
	}
}
