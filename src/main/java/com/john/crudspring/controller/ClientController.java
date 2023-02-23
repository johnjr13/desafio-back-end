package com.john.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.john.crudspring.dto.ClientDTO;
import com.john.crudspring.service.ClientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    //Listar os cursos
    @GetMapping
    public @ResponseBody List<ClientDTO> list() {
        return clientService.list();
    }

    //Buscar curso por ID    
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable @NotNull @Positive Long id){
        return clientService.findById(id);
    }


    //Criar um curso
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClientDTO create(@RequestBody @Valid ClientDTO client){
      return clientService.create(client);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid ClientDTO client){
         return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){
       clientService.delete(id);  
    }
}
