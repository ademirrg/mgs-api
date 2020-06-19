package com.mgs.business.businessImpl;

import com.mgs.business.ConsumerBusiness;
import com.mgs.entity.Consumer;
import com.mgs.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerBusinessImpl implements ConsumerBusiness {

    @Autowired
    ConsumerRepository consumerRepository;

    public Boolean existsById(Long id) {
        return consumerRepository.existsById(id);
    }

    public Consumer findById(Long id) {
        return consumerRepository.findById(id).orElse(null);
    }

    public List<Consumer> findByName(String name) {
        return consumerRepository.findByName(name);
    }

    public Consumer save(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    public void deleteById(Long id) {
        consumerRepository.deleteById(id);
    }
}
