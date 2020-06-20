package com.mgs.controller;

import com.mgs.business.ConsumerBusiness;
import com.mgs.dto.ConsumerDTO;
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
    private ResponseEntity<ConsumerDTO> findById(@PathVariable Long id) {
        if (!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerBusiness.findById(id));
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List> findByName(@PathVariable String name) {
        List<ConsumerDTO> consumersDTO = consumerBusiness.findByName(name);

        if (consumersDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumersDTO);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<ConsumerDTO> createConsumer(@Valid @RequestBody ConsumerDTO consumerDTO) {
        if(consumerDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consumerBusiness.save(consumerDTO));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<ConsumerDTO> updateConsumer(@PathVariable Long id, @Valid @RequestBody ConsumerDTO consumerDTO) {
        if(!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumerDTO.setId(id);
        return ResponseEntity.ok(consumerBusiness.save(consumerDTO));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<ConsumerDTO> deleteConsumer(@PathVariable Long id) {
        if(!consumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        consumerBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
