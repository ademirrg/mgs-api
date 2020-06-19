package com.mgs.business;

import com.mgs.entity.Consumer;

import java.util.List;

public interface ConsumerBusiness {

    Boolean existsById(Long id);

    Consumer findById(Long id);

    List<Consumer> findByName(String name);

    Consumer save(Consumer consumer);

    void deleteById(Long id);

}
