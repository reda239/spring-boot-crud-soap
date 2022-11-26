package com.crudsoap.soapapplication.Repositories;

import com.crudsoap.soapapplication.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
       Client findClientById(Long id);
}
