package com.mgs.controller;

import com.mgs.entity.Consumer;
import com.mgs.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mgs")
public class MgsController {

    @Autowired
    ConsumerRepository consumerRepository;

    @GetMapping("{id}")
    private ResponseEntity<Consumer> findById(@PathVariable Long id) {
        Consumer consumer = consumerRepository.findById(id).orElse(null);
        if (consumer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumer);
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List> findByName(@PathVariable String name) {
        List<Consumer> consumers = consumerRepository.findByName(name);

        if (consumers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumers);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Consumer> createCliente(@RequestBody Consumer consumer) {
        if(consumer.getName() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerRepository.save(consumer));
    }

}
