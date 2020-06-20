package com.mgs.utils;

import com.mgs.dto.ConsumerDTO;
import com.mgs.entity.Consumer;

import java.util.ArrayList;
import java.util.List;

public class MgsConverter {

    public static Consumer convertConsumerDtoToConsumer (ConsumerDTO consumerDTO) {
        Consumer consumer = Consumer.builder()
                .id(consumerDTO.getId())
                .name(consumerDTO.getName())
                .lastName(consumerDTO.getLastName())
                .email(consumerDTO.getEmail())
                .address(consumerDTO.getAddress())
                .phone(consumerDTO.getPhone())
                .complement(consumerDTO.getComplement())
                .cpf(consumerDTO.getCpf())
                .build();
        return consumer;
    }

    public static ConsumerDTO convertConsumerToConsumerDto (Consumer consumer) {
        ConsumerDTO consumerDTO = ConsumerDTO.builder()
                .id(consumer.getId())
                .name(consumer.getName())
                .lastName(consumer.getLastName())
                .email(consumer.getEmail())
                .address(consumer.getAddress())
                .phone(consumer.getPhone())
                .complement(consumer.getComplement())
                .cpf(consumer.getCpf())
                .build();
        return consumerDTO;
    }

    public static List<ConsumerDTO> convertConsumersToConsumersDto (List<Consumer> consumers) {
        List<ConsumerDTO> consumersDTO = new ArrayList<>();
        for (var consumer : consumers) {
            ConsumerDTO consumerDTO = ConsumerDTO.builder()
                    .id(consumer.getId())
                    .name(consumer.getName())
                    .lastName(consumer.getLastName())
                    .email(consumer.getEmail())
                    .address(consumer.getAddress())
                    .phone(consumer.getPhone())
                    .complement(consumer.getComplement())
                    .cpf(consumer.getCpf())
                    .build();
            consumersDTO.add(consumerDTO);
        }
        return consumersDTO;
    }
}
