package com.mgs.business;

import com.mgs.dto.CostumerDTO;

import java.util.List;

public interface CostumerBusiness {
    Boolean existsById(Long id);
    CostumerDTO findById(Long id);
    List<CostumerDTO> findByName(String name);
    CostumerDTO save(CostumerDTO costumerDTO);
    void deleteById(Long id);
}
