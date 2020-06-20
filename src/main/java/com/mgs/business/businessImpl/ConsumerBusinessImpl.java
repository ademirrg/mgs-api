package com.mgs.business.businessImpl;

import com.mgs.business.ConsumerBusiness;
import com.mgs.dto.ConsumerDTO;
import com.mgs.entity.Consumer;
import com.mgs.enums.ExceptionEnum;
import com.mgs.exception.BusinessException;
import com.mgs.repository.ConsumerRepository;
import com.mgs.utils.MgsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerBusinessImpl implements ConsumerBusiness {

    @Autowired
    ConsumerRepository consumerRepository;

    MgsConverter converter;

    public Boolean existsById(Long id) {
        return consumerRepository.existsById(id);
    }

    public ConsumerDTO findById(Long id) {
        return converter.convertConsumerToConsumerDto(consumerRepository.findById(id).orElse(null));
    }

    public List<ConsumerDTO> findByName(String name) {
        return converter.convertConsumersToConsumersDto(consumerRepository.findByName(name));
    }

    public ConsumerDTO save(ConsumerDTO consumerDTO) {
        Consumer person = consumerRepository.findByEmail(consumerDTO.getEmail());
        if(person != null && !person.getId().equals(consumerDTO.getId())) {
            throw new BusinessException(ExceptionEnum.EMAIL_ALREADY_EXIST.getMessage());
        }
        person = consumerRepository.findByCpf(consumerDTO.getCpf());
        if(person != null && !person.getId().equals(consumerDTO.getId())) {
            throw new BusinessException(ExceptionEnum.CPF_ALREADY_EXIST.getMessage());
        }
        return converter.convertConsumerToConsumerDto(consumerRepository.save(converter.convertConsumerDtoToConsumer(consumerDTO)));
    }

    public void deleteById(Long id) {
        consumerRepository.deleteById(id);
    }
}
