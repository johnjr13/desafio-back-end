package com.john.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.john.crudspring.dto.ClientDTO;
import com.john.crudspring.dto.mapper.ClientMapper;
import com.john.crudspring.exception.RecordNotFoundException;
import com.john.crudspring.repository.ClientRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> list() {
        return clientRepository.findAll()
        .stream()
        .map(clientMapper::toDTO)
        .collect(Collectors.toList());
    }

    public ClientDTO findById(@PathVariable @NotNull @Positive Long id){
        return clientRepository.findById(id).map(clientMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ClientDTO create(@Valid @NotNull ClientDTO client){
        return clientMapper.toDTO(clientRepository.save(clientMapper.toEntity(client)));
    }

    public ClientDTO update(@NotNull @Positive Long id, @Valid ClientDTO client){
        return clientRepository.findById(id)
                .map(recordFound ->{
                recordFound.setName(client.name());
                recordFound.setCpf(client.cpf());
                recordFound.setIdade(client.idade());
                return clientMapper.toDTO(clientRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        clientRepository.delete(clientRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id))); 
    }
}
