package com.mgs.business;

import com.mgs.dto.ConsumerDTO;

import java.util.List;

public interface ConsumerBusiness {
    Boolean existsById(Long id);
    ConsumerDTO findById(Long id);
    List<ConsumerDTO> findByName(String name);
    ConsumerDTO save(ConsumerDTO consumerDTO);
    void deleteById(Long id);
}
