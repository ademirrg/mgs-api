package com.mgs.repository;

import com.mgs.entity.Consumer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ConsumerRepository extends JpaRepository <Consumer, Long>{
    List<Consumer> findByName(String name);
    Consumer findByEmail(String email);
    Consumer findByCpf(String cpf);
}
