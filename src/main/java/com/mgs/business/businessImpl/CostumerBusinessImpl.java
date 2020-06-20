package com.mgs.business.businessImpl;

import com.mgs.business.CostumerBusiness;
import com.mgs.dto.CostumerDTO;
import com.mgs.entity.Costumer;
import com.mgs.enums.ExceptionEnum;
import com.mgs.exception.BusinessException;
import com.mgs.repository.CostumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerBusinessImpl implements CostumerBusiness {

    @Autowired
    CostumerRepository costumerRepository;

    @Autowired
    ModelMapper mapper;

    public Boolean existsById(Long id) {
        return costumerRepository.existsById(id);
    }

    public CostumerDTO findById(Long id) {
        return mapper.map(costumerRepository.findById(id), CostumerDTO.class);
    }

    public List<CostumerDTO> findByName(String name) {
        List<Costumer> costumers = costumerRepository.findByName(name);
        return costumers.stream()
                .map(costumer -> mapper.map(costumer, CostumerDTO.class))
                .collect(Collectors.toList());
    }

    public CostumerDTO save(CostumerDTO costumerDTO) {
        Costumer person = costumerRepository.findByCpf(costumerDTO.getCpf());
        if(isOtherPerson(person, costumerDTO)) {
            throw new BusinessException(ExceptionEnum.CPF_ALREADY_EXIST.getMessage());
        }
        person = costumerRepository.findByEmail(costumerDTO.getEmail());
        if(isOtherPerson(person, costumerDTO)) {
            throw new BusinessException(ExceptionEnum.EMAIL_ALREADY_EXIST.getMessage());
        }
        Costumer costumer = mapper.map(costumerDTO, Costumer.class);
        return mapper.map(costumerRepository.save(costumer), CostumerDTO.class);
    }

    public void deleteById(Long id) {
        costumerRepository.deleteById(id);
    }

    public boolean isOtherPerson(Costumer person, CostumerDTO costumerDTO) {
        return person != null && !person.getId().equals(costumerDTO.getId());
    }
}
