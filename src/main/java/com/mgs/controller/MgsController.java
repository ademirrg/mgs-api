package com.mgs.controller;

import com.mgs.entity.Cliente;
import com.mgs.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mgs")
public class MgsController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("{id}")
    private ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List> findByName(@PathVariable String name) {
        List<Cliente> clientes = clienteRepository.findByName(name);

        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        if(cliente.getName() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

}
