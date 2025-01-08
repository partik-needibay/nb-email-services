package com.needibay.email.repository;

import com.needibay.email.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Integer> {

    @Query(value = "select * from nb_system_configuration where microservice = :optionKey", nativeQuery = true)
    public Configuration findByConfigKey(String optionKey);
}
