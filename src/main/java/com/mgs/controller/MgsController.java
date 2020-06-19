package com.mgs.controller;

import com.mgs.business.ConsumerBusiness;
import com.mgs.entity.Consumer;
import com.mgs.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mgs")
public class MgsController {

    @Autowired @Lazy
    ConsumerBusiness consumerBusiness;

    @GetMapping("{id}")
    private ResponseEntity<Consumer> findById(@PathVariable Long id) {
        if (!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerBusiness.findById(id));
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List> findByName(@PathVariable String name) {
        List<Consumer> consumers = consumerBusiness.findByName(name);

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
        return ResponseEntity.ok(consumerBusiness.save(consumer));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Consumer> updateConsumer(@PathVariable Long id, @Valid @RequestBody Consumer consumer) {
        if(!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumer.setId(id);
        return ResponseEntity.ok(consumerBusiness.save(consumer));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Consumer> deleteConsumer(@PathVariable Long id) {
        if(!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumerBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
