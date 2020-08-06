package com.mgs.business;

import com.mgs.dto.CostumerDTO;

import java.util.List;
import java.util.Optional;

public interface CostumerBusiness {
    Boolean existsById(Long id);
    Optional<CostumerDTO> findById(Long id);
    List<CostumerDTO> findByName(String name);
    CostumerDTO save(CostumerDTO costumerDTO);
    void deleteById(Long id);
}
