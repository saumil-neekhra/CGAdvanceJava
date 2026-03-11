package in.cg.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringconfigserverApplication.class, args);
	}

}
