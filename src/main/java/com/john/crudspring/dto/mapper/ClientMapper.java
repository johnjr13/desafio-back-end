package com.john.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.john.crudspring.dto.ClientDTO;
import com.john.crudspring.model.Client;

@Component
public class ClientMapper {
    
    public ClientDTO toDTO(Client client){
        if(client == null){
            return null;
        }
        return new ClientDTO(client.getId(), client.getName(), client.getCpf(), client.getIdade());
    }

    public Client toEntity(ClientDTO clientDTO){
        if(clientDTO == null){
            return null;
        }

        Client client = new Client();
        if (clientDTO.id() != null) {
            client.setId(clientDTO.id());
        }
        client.setName(clientDTO.name());
        client.setCpf(clientDTO.cpf());
        client.setIdade(clientDTO.idade());
        return client;
    }
}
