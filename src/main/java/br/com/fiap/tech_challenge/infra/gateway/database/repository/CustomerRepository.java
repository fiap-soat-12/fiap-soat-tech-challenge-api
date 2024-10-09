package br.com.fiap.tech_challenge.infra.gateway.database.repository;

import br.com.fiap.tech_challenge.infra.gateway.database.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

	Optional<CustomerEntity> findByDocument(String document);

}