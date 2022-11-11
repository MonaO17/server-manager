package com.testwebapp.servermanager;

import com.testwebapp.servermanager.enumeration.Status;
import com.testwebapp.servermanager.model.Server;
import com.testwebapp.servermanager.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerManagerApplication.class, args);
	}

//runs after the app has been initialized
	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB",
					"Personal PC", "http://localhost:8080/server/image/server-01.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB",
					"Dell Tower", "http://localhost:8080/server/image/server-02.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.21", "MS 2008", "132 GB",
					"Web Server", "http://localhost:8080/server/image/server-03.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB",
					"Mail Server", "http://localhost:8080/server/image/server-04.png", Status.SERVER_DOWN));
		};
	}

}
