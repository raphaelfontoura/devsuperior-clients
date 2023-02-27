package com.github.raphaelfontoura.registerclients.dto;

import com.github.raphaelfontoura.registerclients.entities.Client;

import java.time.Instant;

public record ClientDTO(
        Long id,
        String name,
        String cpf,
        Double income,
        Instant birthDate,
        Integer children
) {
    public ClientDTO(Client client) {
        this(client.getId(),
                client.getName(),
                client.getCpf(),
                client.getIncome(),
                client.getBirthDate(),
                client.getChildren());
    }
}
