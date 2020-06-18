package com.mgs.controller;

import com.mgs.entity.Consumer;
import com.mgs.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/mgs")
public class MgsController {

    @Autowired
    ConsumerRepository consumerRepository;

    @GetMapping("{id}")
    private ResponseEntity<Consumer> findById(@PathVariable Long id) {
        if (!consumerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerRepository.findById(id).orElse(null));
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
    private ResponseEntity<Consumer> createConsumer(@Valid @RequestBody Consumer consumer) {
        if(consumer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerRepository.save(consumer));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Consumer> updateConsumer(@Valid @PathVariable Long id, @RequestBody Consumer consumer) {
        if(!consumerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumer.setId(id);
        return ResponseEntity.ok(consumerRepository.save(consumer));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Consumer> deleteConsumer(@PathVariable Long id) {
        if(!consumerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
