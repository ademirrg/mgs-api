package com.mgs.controller;

import com.mgs.business.CostumerBusiness;
import com.mgs.dto.CostumerDTO;
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
    CostumerBusiness costumerBusiness;

    @GetMapping("{id}")
    private ResponseEntity<CostumerDTO> findById(@PathVariable Long id) {
        if (!costumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(costumerBusiness.findById(id));
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<List> findByName(@PathVariable String name) {
        List<CostumerDTO> costumersDTO = costumerBusiness.findByName(name);

        if (costumersDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(costumersDTO);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<CostumerDTO> createCostumer(@Valid @RequestBody CostumerDTO costumerDTO) {
        if(costumerDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(costumerBusiness.save(costumerDTO));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<CostumerDTO> updateCostumer(@PathVariable Long id, @Valid @RequestBody CostumerDTO costumerDTO) {
        if(!costumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        costumerDTO.setId(id);
        return ResponseEntity.ok(costumerBusiness.save(costumerDTO));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<CostumerDTO> deleteCostumer(@PathVariable Long id) {
        if(!costumerBusiness.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        costumerBusiness.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
