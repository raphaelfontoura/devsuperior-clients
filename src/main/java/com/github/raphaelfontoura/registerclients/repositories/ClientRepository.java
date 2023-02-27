package com.github.raphaelfontoura.registerclients.repositories;

import com.github.raphaelfontoura.registerclients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
