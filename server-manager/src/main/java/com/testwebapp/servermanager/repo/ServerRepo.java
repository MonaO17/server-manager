package com.testwebapp.servermanager.repo;

import com.testwebapp.servermanager.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {

    Server findByIpAddress(String ipAddress);
}
