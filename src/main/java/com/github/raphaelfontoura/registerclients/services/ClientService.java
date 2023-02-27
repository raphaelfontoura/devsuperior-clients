package com.github.raphaelfontoura.registerclients.services;

import com.github.raphaelfontoura.registerclients.dto.ClientDTO;
import com.github.raphaelfontoura.registerclients.entities.Client;
import com.github.raphaelfontoura.registerclients.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Page<ClientDTO> getAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    public ClientDTO getById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return new ClientDTO(client);
    }

    public ClientDTO createNew(ClientDTO dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client);
        return new ClientDTO(repository.save(client));
    }

    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(dto, client);
            return new ClientDTO(repository.save(client));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Client not found");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException | DataIntegrityViolationException e) {
            throw new EntityNotFoundException("Client not found");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setBirthDate(dto.birthDate());
        entity.setChildren(dto.children());
    }
}
