package com.example.ed.repositories;

import com.example.ed.entities.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepo extends JpaRepository<Configurations,Long> {
    Configurations findByConfigurationName(String configName);
}
